<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend\Peg;

/**
 * https://github.com/python/cpython/blob/3.12/Lib/token.py
 */
enum TokenType: int {
    case EndMarker = 0;
    case Name = 1;
    case Number = 2;
    case String = 3;
    case NewLine = 4;
    case Indent = 5;
    case Dedent = 6;
    case LeftParen = 7;
    case RightParen = 8;
    case LeftSquareBrace = 9;
    case RightSquareBrace = 10;
    case Colon = 11;
    case Comma = 12;
    case Semicolon = 13;
    case Plus = 14;
    case Minus = 15;
    case Star = 16;
    case Slash = 17;
    case VertBar = 18;
    case Ampersand = 19;
    case Less = 20;
    case Greater = 21;
    case Equal = 22;
    case Dot = 23;
    case Percent = 24;
    case LeftBrace = 25;
    case RightBrace = 26;
    case EqualEqual = 27;
    case NotEqual = 28;
    case LessEqual = 29;
    case GreaterEqual = 30;
    case Tilde = 31;
    case Circumflex = 32;
    case LeftShift = 33;
    case RightShift = 34;
    case DoubleStar = 35;
    case PlusEqual = 36;
    case MinusEqual = 37;
    case StarEqual = 38;
    case SlashEqual = 39;
    case PercentEqual = 40;
    case AmpersandEqual = 41;
    case VertBarEqual = 42;
    case CircumflexEqual = 43;
    case LeftShiftEqual = 44;
    case RightShiftEqual = 45;
    case DoubleStarEqual = 46;
    case DoubleSlash = 47;
    case DoubleSlashEqual = 48;
    case At = 49;
    case AtEqual = 50;
    case RightArrow = 51;
    case Ellipsis = 52;
    case ColonEqual = 53;
    case Exclamation = 54;
    case Op = 55;
    case Await = 56;
    case Async = 57;
    case TypeIgnore = 58;
    case TypeComment = 59;
    case SoftKeyword = 60;
    case FStringStart = 61;
    case FstringMiddle = 62;
    case FstringEnd = 63;
    case Comment = 64;
    case NL = 65;
    case ErrorToken = 66;
    case Encoding = 67;
    case NTokens = 68;
    case NtOffset = 256;
}
