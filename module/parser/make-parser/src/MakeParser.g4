parser grammar MakeParser;

options { tokenVocab = MakeLexer; }

program: stmts* EOF;

stmts: EOL* stmt (EOL+ stmt)* EOL*;

stmt: (varDef | varRef | directiveCall | ruleDef);

varDef: WORD ASSIGN WORD+;
varRef: (VAR_REF_LPAREN varRefText VAR_REF_RPAREN)
        | (VAR_REF_LBRACE varRefText VAR_REF_RBRACE);

varRefText: (VAR_REF_TEXT | varRef)*;

directiveCall: conditionalDirectiveCall | otherDirectiveCall;
conditionalDirectiveCall: ifCondition elseClause* ENDIF;
ifCondition: ifDefCondition | ifNdefCondition | ifEqCondition | ifNeqCondition;

otherDirectiveCall:
      exportDirectiveCall
    | unexportDirectiveCall
    | vpathDirectiveCall
    | includeDirectiveCall
    | mincludeDirectiveCall
    | sincludeDirectiveCall
    | loadDirectiveCall
    | mloadDirectiveCall
    | defineDirectiveCall
    | undefineDirectiveCall
    | overrideDirectiveCall
    | privateDirectiveCall;

// https://www.gnu.org/software/make/manual/make.html#Conditional-Syntax
ifDefCondition: IFDEF (varRef | varName) stmts;
ifNdefCondition: IFNDEF (varRef | varName) stmts;
ifEqCondition: IFEQ (
    LPAREN varRef COMMA varRef RPAREN
    | quotedVarRef quotedVarRef
) stmts;
quotedVarRef: squotedVarRef | dquotedVarRef;
squotedVarRef: ESC SQUOTE varRef ESC SQUOTE;
dquotedVarRef: DQUOTE varRef DQUOTE;
ifNeqCondition: IFNEQ (
    LPAREN varRef COMMA varRef RPAREN
    | quotedVarRef quotedVarRef
) stmts;
elseClause: ELSE (ifCondition? | stmts);
varName: WORD;

exportDirectiveCall: EXPORT/* todo */;
unexportDirectiveCall: UNEXPORT/* todo */;
vpathDirectiveCall: VPATH/* todo */;
includeDirectiveCall: INCLUDE/* todo */;
mincludeDirectiveCall: MINCLUDE/* todo */;
sincludeDirectiveCall: SINCLUDE/* todo */;
loadDirectiveCall: LOAD/* todo */;
mloadDirectiveCall: MLOAD/* todo */;
defineDirectiveCall: DEFINE /* todo */;
undefineDirectiveCall: UNDEFINE /* todo */;
overrideDirectiveCall: OVERRIDE /* todo */;
privateDirectiveCall: PRIVATE /* todo */;

ruleDef: TARGET prerequisite* shellCmd*;
prerequisite: varRef | targetRef;
targetRef: WORD;
shellCmd: SHELL_CMD;