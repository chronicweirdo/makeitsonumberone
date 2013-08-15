grammar Exocortex;
@header
{
package com.chronicweirdo.exocortex.prototype0.parser;
}

program : statement (WS* ';' WS* statement)*;

statement
	: define
	| value
	| add;

add : (ID '=')? 'add' map;

// defining values, accessing values directly
define : ID '=' (value | reference);
map : '[:]'
	| '[' entry (',' entry)* ']';
array
	: '[]'
	| '[' value (',' value)* ']';
entry: key ':' value;
key : STRING | ID;
value
	: primitive
	| map
	| array;
primitive : STRING | NUMBER | BOOLEAN;

// a reference refers to a 
reference : ID referenceElement*;
referenceElement
	: '[' (ID | NUMBER) ']'
	| '.' ID;

BOOLEAN : 'true' | 'false';
STRING : '"' ~[\"]* '"';
ID : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
NUMBER
	: ('0'..'9')* '.' ('0'..'9')+
	| '0'..'9'+;
WS : [ \t\n\r]+ -> skip ;
