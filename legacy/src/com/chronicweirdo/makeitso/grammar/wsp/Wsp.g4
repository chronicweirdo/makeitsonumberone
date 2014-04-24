grammar Wsp;
@header
{
package com.chronicweirdo.makeitso.grammar.wsp;
}


query : (line ';')+;

line : declare? statement;
declare : ID ' '* '=' ' '*;

statement
	: assignment
	| upload;

assignment : value;
upload : 'upload' ('file'|'folder') value;

value : STRING;

// LEXER
STRING : '"' ~[\"]* '"' ;
ID     : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
NUMBER    : ('0'..'9'|'.')+;
BLOCK_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);
//WS : (' '|'\r'|'\t'|'\n')+ -> channel(HIDDEN);//skip ;
WS : [ \r\t\n]+ -> channel(HIDDEN);