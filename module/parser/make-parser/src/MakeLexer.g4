lexer grammar MakeLexer;

options { superClass = BaseLexer; }

channels { COMMENTS }

tokens {
/*    LBRACE,
    RBRACE*/
    VAR_REF_WORD,
    VAR_REF_RPAREN,
    VAR_REF_RBRACE
}

COMMENT: LineComment -> channel(COMMENTS);
ASSIGN: ':=' | '=' | '?=' | '::=' | '+=' | '!=';
//COLON: ':';
DOLLAR: '$' -> skip, pushMode(VAR_REF_MODE);
LPAREN: '(';
RPAREN: ')';
ESC: '\\';
SQUOTE: '\'';
DQUOTE: '"';
COMMA: ',';

CONTINUATION: Continuation -> skip;
EOL: Vws+ -> skip;

TARGET: ~('\r' | '\n' | '\f')+ ':' -> pushMode(PREREQUISITE_MODE);

// ---
// Directives

// Conditional directive. NB: `if` is not conditional but built-in function call:
IFDEF: 'ifdef';
IFNDEF: 'ifndef';
IFEQ: 'ifeq';
IFNEQ: 'ifneq';
ELSE: 'else';
ENDIF: 'endif';
// Other directives
EXPORT: 'export';
UNEXPORT: 'unexport';
VPATH: 'vpath';
INCLUDE: 'include';
MINCLUDE: '-include';
SINCLUDE: 'sinclude';
LOAD: 'load';
MLOAD: '-load';
DEFINE: 'define';
UNDEFINE: 'undefine';
OVERRIDE: 'override';
PRIVATE: 'private';

// ---

// todo: handle strings?
WORD: ~('\r' | '\n' | '\f' | '\t' | ' ' | '$' | '(' | ')' | '{' | '}' | ',' | '\\' | '\'' | '"')+;
WS: [ \f\t] -> skip;

// ---

mode VAR_REF_MODE;

VAR_REF_CONTINUATION: Continuation -> skip;
VAR_REF_WS: Hws+ -> skip;
VAR_REF_LPAREN: '(';
VAR_REF_LBRACE: '{';
VAR_REF_RPAREN: ')' -> popMode;
VAR_REF_RBRACE: '}' -> popMode;
// We don't parse function calls - they should be parsed by a separate parser as theirs arguments depend from a function and can contain `text` argument, like `error` function.
VAR_REF_TEXT: ~('\r' | '\n' | '\f' | '$' | '(' | ')' | '{' | '}' | '\\' | '\t')+;
VAR_REF_DOLLAR: '$' -> skip, pushMode(VAR_REF_MODE);

mode PREREQUISITE_MODE;

PREREQUISITE_CONTINUATION: '\\' Vws -> skip;
// todo handle strings?
PREREQUISITE: ~('\r' | '\n' | '\f' | ' ' | '$' | '(' | ')' | '{' | '}')+;
PREREQUISITE_WS: [ \f] -> skip;
PREREQUISITE_COMMENT: LineComment -> type(COMMENT);//channel (CommentsCh);
PREREQUISITE_EOL: Vws+ -> skip, pushMode(RECEIPT_MODE);

// ---

mode RECEIPT_MODE;

RECEIPT_COMMENT: LineComment -> type(COMMENT);
SHELL_CMD: '\t' ~[\r\n\f]+;// -> more, popMode, pushMode(PREREQUISITE);
RECEIPT_CONTINUATION: '\\' Vws -> skip;
RECEIPT_EOL: Vws+ -> skip;
OTHER: ~'\t'-> more, mode(DEFAULT_MODE);

// ---

fragment Hws
   : [ \t]
   ;

fragment Vws
   : [\r\n\f]
   ;

fragment LineComment
   : '#' ~[\r\n\f]*;

fragment Continuation: '\\' Vws;

//fragment VarRefBegin: '$' (Continuation | Hws)+;