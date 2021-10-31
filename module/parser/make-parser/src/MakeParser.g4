parser grammar MakeParser;

options { tokenVocab = MakeLexer; }

@members {

}

program: stmts* EOF;

stmts: EOL* stmt (EOL+ stmt)* EOL*;

stmt: (var | directive | ruleDef);

var: varDef | varRef;
varDef: WORD ASSIGN WORD+;
// E.g.: $(foo) or $(built-in-fn arg1,arg2,...) like $(call arg1,arg2,...). Function calls are also var references.
varRef: (VAR_REF_LPAREN VAR_REF_WORD (varRef | VAR_REF_WORD_COMMA)* VAR_REF_RPAREN) | (VAR_REF_LBRACE VAR_REF_WORD (varRef | VAR_REF_WORD_COMMA)* VAR_REF_RBRACE);
//DOLLAR ((LPAREN varName fnArgs? RPAREN) | (LBRACE varName fnArgs? RBRACE));
fnArgs: fnArg (COMMA? fnArg)*;
fnArg: varRef | WORD;

directive: conditionalDirective | otherDirective;

conditionalDirective: ifCondition elseClause* ENDIF;
ifCondition: ifDefCondition | ifNdefCondition | ifEqCondition | ifNeqCondition;

otherDirective: exportDirective
    | unexportDirective
    | vpathDirective
    | includeDirective
    | mincludeDirective
    | sincludeDirective
    | loadDirective
    | mloadDirective
    | defineDirective
    | undefineDirective
    | overrideDirective
    | privateDirective;

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

exportDirective: EXPORT/* todo */;
unexportDirective: UNEXPORT/* todo */;
vpathDirective: VPATH/* todo */;
includeDirective: INCLUDE/* todo */;
mincludeDirective: MINCLUDE/* todo */;
sincludeDirective: SINCLUDE/* todo */;
loadDirective: LOAD/* todo */;
mloadDirective: MLOAD/* todo */;
defineDirective: DEFINE /* todo */;
undefineDirective: UNDEFINE /* todo */;
overrideDirective: OVERRIDE /* todo */;
privateDirective: PRIVATE /* todo */;

ruleDef: TARGET prerequisite* shellCmd*;
prerequisite: varRef | targetRef;
targetRef: WORD;
shellCmd: SHELL_CMD;