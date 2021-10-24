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
EOL: Vws+;

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
VAR_REF_LPAREN: '(' -> pushMode(VAR_REF1_MODE);//, type(VALPAREN);
VAR_REF_LBRACE: '{' -> pushMode(VAR_REF1_MODE);//, type(LBRACE);

mode VAR_REF1_MODE;

VAR_REF1_CONTINUATION: Continuation -> skip;
VAR_REF_RPAREN: ')' -> popMode, popMode, type(VAR_REF_RPAREN);
VAR_REF_RBRACE: '}' -> popMode, popMode, type(VAR_REF_RBRACE);
VAR_REF1_DOLLAR: '$' -> skip, pushMode(VAR_REF_MODE);
VAR_REF1_WORD: ~('\r' | '\n' | '\f' | '$' | '(' | ')' | '{' | '}' | ','/* | '\\'*/)+ -> type(VAR_REF_WORD);
VAR_REF_WORD_COMMA: ~('\r' | '\n' | '\f' | '$' | '(' | ')' | '{' | '}'/* | '\\'*/)+;
VAR_REF_COMMA: ',';

// ---

mode PREREQUISITE_MODE;

PREREQUISITE_CONTINUATION: '\\' Vws -> skip;
// todo handle strings?
PREREQUISITE: ~('\r' | '\n' | '\f' | ' ' | '$' | '(' | ')' | '{' | '}')+;
PREREQUISITE_WS: [ \f] -> skip;
PREREQUISITE_COMMENT: LineComment -> type(COMMENT);//channel (CommentsCh);
PREREQUISITE_EOL: Vws+ -> pushMode(RECEIPT_MODE);

// ---

mode RECEIPT_MODE;

RECEIPT_COMMENT: LineComment -> type(COMMENT);
SHELL_CMD: '\t' ~[\r\n\f]+;// -> more, popMode, pushMode(PREREQUISITE);
RECEIPT_CONTINUATION: '\\' Vws -> skip;
RECEIPT_EOL: Vws+ -> type(EOL);
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