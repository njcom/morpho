<?php declare(strict_types=1);
/**
 * This file is part of njcom/framework
 * It is distributed under the 'Apache License Version 2.0' license.
 * See the https://github.com/njcom/framework/blob/main/LICENSE for the full license text.
 */
namespace Morpho\Compiler\Frontend;

enum Lexeme: string {
    case At = '@';
    case BackSlash = '\\';
    case Backtick = '`';
    case Caret = '^';
    case Colon = ':';
    case Comma = ',';
    case Dollar = '$';
    case Dot = '.';
    case DoubleQuote = '"';
    case Equal = '=';
    case Exclamation = '!';
    case Hash = '#';
    case LAngleBracket = '<';
    case LBrace = '{';
    case LBracket = '[';
    case LParen = '(';
    case Minus = '-'; // aka dash, hyphen
    case Percent = '%';
    case Plus = '+';
    case Question = '?';
    case RAngleBracket = '>';
    case RBrace = '}';
    case RBracket = ']';
    case RParen = ')';
    case Semicolon = ';';
    case SingleQuote = "'"; // aka apostrophe
    case Slash = '/';
    case Star = '*'; // asterisk
    case Tilde = '~';
    case VerticalBar = '|';
}