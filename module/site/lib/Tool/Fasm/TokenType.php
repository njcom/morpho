<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Tool\Fasm;

enum TokenType {
    case AmpersandSpecial; // &
    case BackslashSpecial; // \
    case BacktickSpecial; // `
    case BaseAddress; // $$
    case ColonSpecial; // :
    case CommaSpecial; // ,
    case Comment; // ; This is a comment
    case CurrentAddress; // $
    case DotSpecial; // .
    case DoubleQuotedString; // "foo"
    case EqualsSpecial; // =
    case ExclamationSpecial; // !
    case GreaterThanSpecial; // >
    case HashSpecial; // #
    case Identifier; // foo
    case IncludeKeyword; // include
    case LeftBraceSpecial; // {
    case LeftBracketSpecial; // [
    case LeftParenSpecial; // (
    case LessThanSpecial; // <
    case MinusSpecial; // -
    case NewLine; // \n
    case Number; // 123
    case OrgKeyword; // org
    case PipeSpecial; // |
    case PlusSpecial; // +
    case QuestionSpecial; // ?
    case RightBraceSpecial; // }
    case RightBracketSpecial; // ]
    case RightParenSpecial; // )
    case SingleQuotedString; // 'foo'
    case SlashSpecial; // /
    case SpecialParameter1; // %
    case SpecialParameter2; // %%
    case StarSpecial; // *
    case TildeSpecial; // ~
}