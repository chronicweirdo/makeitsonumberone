grammar Maps;
@header
{
package com.chronicweirdo.makeitso.grammar.maps;
}


program : (statement ';')+;
statement
	: function;

function
	: functionLong
	| functionShort
	//| ID ('.' ID)* '=' value // shorthand set function
	//| ID ('.' ID)* // shorthand get function
	;
functionLong : '|' value;
functionShort : '(' value value* ')'; // shorthand functions
	
map
	: '[' entry (',' entry)* ']'
	| '[' ':' ']';
list
	: '[' value (',' value)* ']'
	| '[' ']';
entry : key ':' value;
key : value;
value
	: STRING
	| ID
	| NUMBER
	| map
	| list
	| value '[' key ']'
	| function;

// LEXER
STRING : '"' ~[\"]* '"' ;
ID     : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
NUMBER    : ('0'..'9'|'.')+;
BLOCK_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);
WS : [ \r\t\n]+ -> channel(HIDDEN);