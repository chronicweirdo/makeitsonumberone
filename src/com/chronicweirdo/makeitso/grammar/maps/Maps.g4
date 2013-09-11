grammar Maps;
@header
{
package com.chronicweirdo.makeitso.grammar.maps;
}


program : (statement ';')+;
statement
	: map
	| value; 

map
	: '[' entry (',' entry)* ']'
	| '[' ':' ']';
entry : key ':' value;
key : value;
value
	: ID
	| STRING
	| NUMBER
	| map;

// LEXER
STRING : '"' ~[\"]* '"' ;
ID     : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
NUMBER    : ('0'..'9'|'.')+;
BLOCK_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);
WS : [ \r\t\n]+ -> channel(HIDDEN);