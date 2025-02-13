<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

use UnexpectedValueException;

use function iter\rewindable\product;
use function Morpho\Base\map;
use function Morpho\Base\permutations;

/**
 * Augment class for the GrammarLexer
 * https://github.com/python/cpython/blob/fc94d55ff453a3101e4c00a394d4e38ae2fece13/Lib/tokenize.py#L65
 */
class PythonTokenizerRe {
    public const string COMMENT_RE = '#[^\r\n]*';
    public const string WHITESPACE_RE = '[ \f\t]*';
    public const string NAME_RE = '\w+';
    // Numbers
    public const string HEX_NUMBER_RE = '0[xX](?:_?[0-9a-fA-F])+';
    public const string BIN_NUMBER_RE = '0[bB](?:_?[01])+';
    public const string OCT_NUMBER_RE = '0[oO](?:_?[0-7])+';
    public const string DEC_NUMBER_RE = '(?:0(?:_?0)*|[1-9](?:_?[0-9])*)';

    # Tail end of ' string.
    public const string TAIL_END_OF_SINGLE_QUOTE = "[^'\\\\]*(?:\\\\.[^'\\\\]*)*'";
    # Tail end of " string.
    public const string TAIL_END_OF_DOUBLE_QUOTE = '[^"\\\\]*(?:\\\\.[^"\\\\]*)*"';
    # Tail end of ''' string.
    public const string TAIL_END_OF_SINGLE3_QUOTE = "[^'\\\\]*(?:(?:\\\\.|'(?!''))[^'\\\\]*)*'''";
    # Tail end of """ string.
    public const string TAIL_END_OF_DOUBLE3_QUOTE = '[^"\\\\]*(?:(?:\\\\.|"(?!""))[^"\\\\]*)*"""';

    public static function isIdentifier(string $v): bool {
        // @todo: support non ASCII identifiers https://docs.python.org/3/reference/lexical_analysis.html#identifiers
        return (bool) preg_match('~^[a-z_][a-z_0-9]*$~AsDui', $v);
    }

    public static function endPatterns(): array {
        $endPatterns = [];
        $single = self::TAIL_END_OF_SINGLE_QUOTE;
        $double = self::TAIL_END_OF_DOUBLE_QUOTE;
        $single3 = self::TAIL_END_OF_SINGLE3_QUOTE;
        $double3 = self::TAIL_END_OF_DOUBLE3_QUOTE;
        foreach (self::allStringPrefixes() as $prefix) {
            $endPatterns[$prefix . "'"] = $single;
            $endPatterns[$prefix . '"'] = $double;
            $endPatterns[$prefix . "'''"] = $single3;
            $endPatterns[$prefix . '"""'] = $double3;
        }
        return $endPatterns;
    }

    public static function tripleQuotedPrefixes(): array {
        $tripleQuotedPrefixes = [];
        foreach (self::allStringPrefixes() as $prefix) {
            $tripleQuotedPrefixes[] = $prefix . '"""';
            $tripleQuotedPrefixes[] = $prefix . "'''";
        }
        return $tripleQuotedPrefixes;
    }

    public static function singleQuotedPrefixes(): array {
        $singleQuotedPrefixes = [];
        foreach (self::allStringPrefixes() as $prefix) {
            $singleQuotedPrefixes[] = $prefix . '"';
            $singleQuotedPrefixes[] = $prefix . "'";
        }
        return $singleQuotedPrefixes;
    }

    /**
     * @param ...$choices
     * @return string
     */
    public static function groupRe(...$choices): string {
        return '(' . implode('|', $choices) . ')';
    }

    /**
     * @param ...$choices
     * @return string
     */
    public static function anyRe(...$choices): string {
        if (!count($choices)) {
            throw new UnexpectedValueException("RE can't be empty");
        }
        return self::groupRe(...$choices) . '*';
    }

    /**
     * @param ...$choices
     * @return string
     */
    public static function maybeRe(...$choices): string {
        if (!count($choices)) {
            throw new UnexpectedValueException("RE can't be empty");
        }
        return self::groupRe(...$choices) . '?';
    }

    public static function intNumberRe(): string {
        return self::groupRe(self::HEX_NUMBER_RE, self::BIN_NUMBER_RE, self::OCT_NUMBER_RE, self::DEC_NUMBER_RE);
    }

    public static function floatNumberRe(): string {
        $exponentRe = '[eE][-+]?[0-9](?:_?[0-9])*';
        $pointFloatRe = self::groupRe('[0-9](?:_?[0-9])*\\.(?:[0-9](?:_?[0-9])*)?', '\\.[0-9](?:_?[0-9])*') . self::maybeRe($exponentRe);
        $expFloatRe = '[0-9](?:_?[0-9])*' . $exponentRe;
        return self::groupRe($pointFloatRe, $expFloatRe);
    }

    public static function imageNumberRe(): string {
        return self::groupRe('[0-9](?:_?[0-9])*[jJ]', self::floatNumberRe() . '[jJ]');
    }

    public static function pseudoTokenRe(): string {
        return self::WHITESPACE_RE
            . self::groupRe(
                self::pseudoExtrasRe(),
                self::numberRe(),
                self::funnyRe(),
                self::contStr(),
                self::NAME_RE,
            );
    }

    public static function allStringPrefixes(): array {
        // The valid string prefixes. Only contain the lower case versions, and don't contain any permutations (include 'fr', but not 'rf'). The various permutations will be generated.
        $validStringPrefixes = ['b', 'r', 'u', 'f', 'br', 'fr'];
        // if we add binary f-strings, add: ['fb', 'fbr']
        $result = ['']; // it may be optional
        foreach ($validStringPrefixes as $prefix) {
            foreach (permutations(str_split($prefix)) as $row) {
                $pairs = [];
                foreach ($row as $c) {
                    $pairs[] = [$c, strtoupper($c)];
                }
                foreach (product(...$pairs) as $u) {
                    $result[] = implode('', $u);
                }
            }
        }
        // {'', 'Br', 'rF', 'rb', 'r', 'F', 'fR', 'U', 'R', 'br', 'FR', 'B', 'Fr', 'f', 'b', 'u', 'rf', 'Rb', 'BR', 'RF', 'bR', 'RB', 'rB', 'fr', 'Rf'}
        return $result;
    }

    public static function stringPrefixRe(): string {
        return self::groupRe(...self::allStringPrefixes());
    }

    public static function contStr(): string {
        // First (or only) line of ' or " string.
        $stringPrefixRe = self::stringPrefixRe();
        return self::groupRe(
            $stringPrefixRe . "'[^\\n'\\\\]*(\\.[^\\n'\\\\]*)*" . self::groupRe("'", '\\\\r?\\n'),
            $stringPrefixRe . '"[^\\n"\\\\]*(\\.[^\\n"\\\\]*)*' . self::groupRe('"', '\\\\r?\\n')
        );
    }

    public static function funnyRe(): string {
        /* Not used
                # Single-line ' or " string.
                String = group(StringPrefix + r"'[^\n'\\]*(?:\\.[^\n'\\]*)*'",
                               StringPrefix + r'"[^\n"\\]*(?:\\.[^\n"\\]*)*"')*/
        // Sorting in reverse order puts the long operators before their prefixes. Otherwise if = came before ==, == would get recognized as two instances of =.
        $exactTokenTypes = array_keys([
            '?'   => TokenType::Op,
            '!'   => TokenType::Exclamation,
            '!='  => TokenType::NotEqual,
            '%'   => TokenType::Percent,
            '%='  => TokenType::PercentEqual,
            '&'   => TokenType::Ampersand,
            '&='  => TokenType::AmpersandEqual,
            '('   => TokenType::LeftParen,
            ')'   => TokenType::RightParen,
            '*'   => TokenType::Star,
            '**'  => TokenType::DoubleStar,
            '**=' => TokenType::DoubleStarEqual,
            '*='  => TokenType::StarEqual,
            '+'   => TokenType::Plus,
            '+='  => TokenType::PlusEqual,
            ','   => TokenType::Comma,
            '-'   => TokenType::Minus,
            '-='  => TokenType::MinusEqual,
            '->'  => TokenType::RightArrow,
            '.'   => TokenType::Dot,
            '...' => TokenType::Ellipsis,
            '/'   => TokenType::Slash,
            '//'  => TokenType::DoubleSlash,
            '//=' => TokenType::DoubleSlashEqual,
            '/='  => TokenType::SlashEqual,
            ':'   => TokenType::Colon,
            ':='  => TokenType::ColonEqual,
            ';'   => TokenType::Semicolon,
            '<'   => TokenType::Less,
            '<<'  => TokenType::LeftShift,
            '<<=' => TokenType::LeftShiftEqual,
            '<='  => TokenType::LessEqual,
            '='   => TokenType::Equal,
            '=='  => TokenType::EqualEqual,
            '>'   => TokenType::Greater,
            '>='  => TokenType::GreaterEqual,
            '>>'  => TokenType::RightShift,
            '>>=' => TokenType::RightShiftEqual,
            '@'   => TokenType::At,
            '@='  => TokenType::AtEqual,
            '['   => TokenType::LeftSquareBrace,
            ']'   => TokenType::RightSquareBrace,
            '^'   => TokenType::Circumflex,
            '^='  => TokenType::CircumflexEqual,
            '{'   => TokenType::LeftBrace,
            '|'   => TokenType::VertBar,
            '|='  => TokenType::VertBarEqual,
            '}'   => TokenType::RightBrace,
            '~'   => TokenType::Tilde,
        ]);
        rsort($exactTokenTypes);
        $escapeReSpecialChars = function (string $re): string {
            return preg_quote($re, '~');
        };
        $specialRe = self::groupRe(...map($escapeReSpecialChars, $exactTokenTypes));
        return self::groupRe('\\r?\\n', $specialRe);
    }

    public static function pseudoExtrasRe(): string {
        return self::groupRe('\\r?\\n|\\Z', self::COMMENT_RE, self::tripleRe());
    }

    private static function numberRe(): string {
        return self::groupRe(self::imageNumberRe(), self::floatNumberRe(), self::intNumberRe());
    }

    private static function tripleRe(): string {
        $stringPrefixRe = self::stringPrefixRe();
        return self::groupRe($stringPrefixRe . "'''", $stringPrefixRe . '"""');
    }
}