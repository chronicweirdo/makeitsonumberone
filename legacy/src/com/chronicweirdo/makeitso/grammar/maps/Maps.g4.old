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
	| functionSet
	| functionGet 
	;
	
functionLong : '|' value;
functionShort : '(' ID value* ')'; // shorthand functions
functionSet : (ID | '.') ('[' key ']')* '=' value; // shorthand set function
functionGet: ID | '.'; // shorthand get function
	
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
	| NUMBER
	| map
	| list
	| function
	| value '[' key ']'
	;

// LEXER
STRING
	: '"' ~[\"]* '"'
	| '\''  ~[\\']* '\'';
ID     : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
NUMBER    : ('0'..'9')+ ('.'('0'..'9')+)?;
BLOCK_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);
WS : [ \r\t\n]+ -> channel(HIDDEN);