grammar Jon;

/*
	JON = Java Object Notation
	JBON = Java Bean Object Notation
	UON = Universal Object Notation
*/
@header
{
package com.chronicweirdo.jon.grammar;
}

object
	: type map // denotes an object
	| map // denotes a map
	| type list // denotes a special collection, like set
	| list // denotes a list
	| value // denotes a basic object
	;

type : '(' ID ('.' ID)* ')' ;
map : '{' entry? (',' entry)* '}' ;
entry : object ':' object ;
list : '[' object? (',' object)* ']' ;

// TODO: handle all java primitive data types http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
value
	: bool
	| STRING
	| NUMBER
	;
bool : TRUE | FALSE ;

// LEXER

TRUE : 'true' ;

FALSE : 'false' ;

STRING
	: '"' ~[\"]* '"'
	| '\''  ~[\\']* '\''
	;
	
ID : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

NUMBER : ('0'..'9')+ ('.'('0'..'9')+)?;

WS : [ \r\t\n]+ -> channel(HIDDEN);