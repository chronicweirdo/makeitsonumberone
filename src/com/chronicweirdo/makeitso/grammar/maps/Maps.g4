grammar Maps;
@header
{
package com.chronicweirdo.makeitso.grammar.maps;
}


program : (statement ';')+;
statement
	: base
	| function
	;

/*function
	: functionLong
	| functionShort
	| functionSet
	| functionGet 
	;
	
functionLong : '|' value;
functionShort : '(' ID value* ')'; // shorthand functions
functionSet : (ID | '.') ('[' key ']')* '=' value; // shorthand set function
functionGet: ID | '.'; // shorthand get function
*/

// DEFINITION OF FUNCTIONS
	
function
	: get
	| set
	| ':' ID value*
	;
	
get
	: '.' // get the root value
	| ('.' key)+
	;
	
set
	: ('.' key)+ '=' (base | function)
	;





// DEFINITION OF VALUES

value
	: base
	| '(' function ')'
	;

base
	: ID
	| STRING
	| NUMBER
	| map
	| list
	;

map
	: '[' entry (',' entry)* ']'
	| '[' ':' ']'
	;
	
list
	: '[' value (',' value)* ']'
	| '[' ']'
	;
	
entry : key ':' value;

key : value;





// LEXER

STRING
	: '"' ~[\"]* '"'
	| '\''  ~[\\']* '\''
	;
	
ID : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

NUMBER : ('0'..'9')+ ('.'('0'..'9')+)?;

BLOCK_COMMENT : '/*' .*? '*/' -> channel(HIDDEN);

LINE_COMMENT : '//' ~[\r\n]* -> channel(HIDDEN);

WS : [ \r\t\n]+ -> channel(HIDDEN);