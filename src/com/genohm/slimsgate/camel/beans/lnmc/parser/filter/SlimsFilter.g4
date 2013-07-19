grammar SlimsFilter;
@header
{
package com.genohm.slimsgate.camel.beans.lnmc.parser.filter;
}

// PARSER
/*
query = fetch_query+ format_query
*/
query : fetchQuery '.' (formatQuery)?;

fetchQuery : datatypeSelection (';' datatypeSelection)*;
datatypeSelection : datatypeName from? filter? order? limit?;
datatypeName : ID;
from : ' from step';
filter: ' filter ' filterTerm (',' filterTerm)*;
filterTerm : attribute '=' attributeValue;
attribute : ID;
attributeValue
	: source '.' attribute
	| STRING;
source : ID;
order : ' order ' orderTerm (',' orderTerm)*;
orderTerm : ID ' ' direction;
direction : 'asc' | 'desc';
limit : ' limit ' INT;

formatQuery : 'format ' formatQueryTerm (',' formatQueryTerm)*;
formatQueryTerm : formatExpression '=' formatName;
formatName : STRING;
formatExpression : formatAttribute (' ' formatLink ' ' formatAttribute)*;
formatAttribute : ID;
formatLink: STRING;


// LEXER

/*
program : ((assignment|expression) ';')+;
 
assignment : ID '=' expression;
 
expression
    : '(' expression ')'                # parenExpression
    | expression ('*'|'/') expression   # multOrDiv
    | expression ('+'|'-') expression   # addOrSubtract
    | 'print' arg (',' arg)*            # print
    | STRING                            # string
    | ID                                # identifier
    | INT                               # integer;
 
arg : ID|STRING;
*/
 
// LEXER
STRING : '"' ~[\"] '"';
ID     : ('a'..'z'|'A'..'Z'|'_')+;
INT    : '0'..'9'+;
WS     : [ \t\n\r]+ -> skip ;