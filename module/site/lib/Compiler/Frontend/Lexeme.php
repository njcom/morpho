<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend;

enum Lexeme: string {
    case Ampersand = '&';
    case At = '@';
    case Backslash = '\\';
    case Backtick = '`';
    case Caret = '^';
    case Colon = ':';
    case Comma = ',';
    case Dollar = '$';
    case Dot = '.';
    case DoubleQuote = '"';
    case Equals = '=';
    case Exclamation = '!';
    case Hash = '#';
    case LeftAngleBracket = '<';
    case LeftBrace = '{';
    case LeftBracket = '[';
    case LeftParen = '(';
    case Minus = '-'; // aka dash, hyphen
    case Percent = '%';
    case Pipe = '|';
    case Plus = '+';
    case Question = '?';
    case RightAngleBracket = '>';
    case RightBrace = '}';
    case RightBracket = ']';
    case RightParen = ')';
    case Semicolon = ';';
    case SingleQuote = "'"; // aka apostrophe
    case Slash = '/';
    case Star = '*'; // asterisk
    case Tilde = '~';
}