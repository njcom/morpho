<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Tool\Fasm;

enum TokenType {
    case AmpersandSpecial;
    case AsteriskSpecial;
    case BackslashSpecial;
    case BacktickSpecial;
    case ColonSpecial;
    case CommaSpecial;
    case DotSpecial;
    case DoubleQuotedString;
    case EqualsSpecial;
    case ExclamationSpecial;
    case GreaterThanSpecial;
    case HashSpecial;
    case Identifier;
    case IncludeKeyword;
    case LeftBraceSpecial;
    case LeftBracketSpecial;
    case LeftParenSpecial;
    case LessThanSpecial;
    case MinusSpecial;
    case Number;
    case OrgKeyword;
    case PipeSpecial;
    case PlusSpecial;
    case QuestionSpecial;
    case RightBraceSpecial;
    case RightBracketSpecial;
    case RightParenSpecial;
    case SingleQuotedString;
    case SlashSpecial;
    case TildeSpecial;
}