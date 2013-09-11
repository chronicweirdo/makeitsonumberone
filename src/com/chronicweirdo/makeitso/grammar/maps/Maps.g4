grammar Maps;
@header
{
package com.chronicweirdo.makeitso.grammar.maps;
}


program : (statement ';')+;
statement
	: assignment
	| print
	| function;
function
	: find;

assignment : variable '=' value;
print : 'print' value;
find : 'find' value STRING;

map
	: '[' entry (',' entry)* ']'
	| '[' ':' ']';
list
	: '[' value (',' value)* ']'
	| '[' ']';
entry : key ':' value;
key : value;
value
	: ID
	| STRING
	| NUMBER
	| map
	| list
	| variable
	| '(' function ')';
variable
	: ('.' ID)+
	| '.';

// LEXER
STRING : '"' ~[\"]* '"' ;
ID     : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
NUMBER    : ('0'..'9'|'.')+;
BLOCK_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);
WS : [ \r\t\n]+ -> channel(HIDDEN);