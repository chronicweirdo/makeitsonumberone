grammar JBON;

/*
	JON = Java Object Notation
	JBON = Java Bean Object Notation
	UON = Universal Object Notation
*/
@header
{
package com.chronicweirdo.jbon.grammar;
}

file : object ;

object
	: type map // denotes an object
	| map // denotes a map
	| type list // denotes a special collection, like set
	| list // denotes a list
	| primitive // denotes a primitive object
	;

type
	: '(' ID ('.' ID)* ')' 
	| ID ('.' ID)* ;
map : '{' entry? (',' entry)* '}' ;
entry : key ':' value ;
key : object | ID ;
value : object ;
list : '[' object? (',' object)* ']' ;

// TODO: handle all java primitive data types http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html


primitive
	: p_int
	| p_long
	| p_float
	| p_double
	| p_string
	| p_char
	| p_boolean
	;

p_int
	: INTEGER
	| HEXADECIMAL
	| BINARY
	;
p_long : INTEGER ('l'|'L') ;
p_float : FLOAT ('f'|'F') ;
p_double : FLOAT ('d'|'D')? ;
p_char : CHAR ;
p_string : STRING ;
p_boolean : TRUE | FALSE ;

// LEXER

NULL : 'null';
TRUE : 'true' ;
FALSE : 'false' ;

//STRING : '"' ~[\"]* '"' ;
STRING : '"' (ESC | ~["\\])* '"' ;
fragment ESC : '\\' (["\\/bfnrt\'] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;

CHAR : '\''  ~[\\']* '\'' ;

ID : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

FLOAT : ('-'|'+')? ('0'..'9')+ '.' ('0'..'9')+ ('e' ('0'..'9')+)?;
INTEGER : ('-'|'+')? ('0'..'9')+ ;
HEXADECIMAL : ('-'|'+')? '0x' HEX+ ;
BINARY : ('-'|'+')? '0b' ('0'|'1')+ ;

WS : [ \r\t\n]+ -> channel(HIDDEN);