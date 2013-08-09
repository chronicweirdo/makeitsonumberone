grammar Exocortex;
@header
{
package com.chronicweirdo.exocortex.parser;
}

query : define;
define : ID '=' value;
map : '[]'
	| '[' entry (',' entry)* ']';
entry: key ':' value;
key : STRING | ID;
value
	: primitive
	| map;
primitive : STRING | NUMBER | BOOLEAN;

BOOLEAN : 'true' | 'false';
STRING : '"' ~[\"] '"';
ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
NUMBER
	: ('0'..'9')* '.' ('0'..'9')+
	| '0'..'9'+;
WS : [ \t\n\r]+ -> skip ;
