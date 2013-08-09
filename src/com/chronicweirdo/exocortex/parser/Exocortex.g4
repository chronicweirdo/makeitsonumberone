grammar Exocortex;
@header
{
package com.chronicweirdo.exocortex.parser;
}

query : STRING;
map : '[]'
	| '[' entry (',' entry)* ']';
entry: key ':' value;
key : STRING | ID;
value
	: primitive
	| map;
primitive : STRING | NUMBER | BOOLEAN;


STRING : '"' ~[\"] '"';
ID : ('a'..'z'|'A'..'Z'|'_')+;
NUMBER
	: ('0'..'9')* '.' ('0'..'9')+
	| '0'..'9'+;
WS : [ \t\n\r]+ -> skip ;
BOOLEAN : 'true' | 'false';