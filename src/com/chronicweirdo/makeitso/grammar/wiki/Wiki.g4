grammar Wiki;
@header
{
package com.chronicweirdo.makeitso.grammar.wiki;
}

page : (section)+;

section
	: tag
	| link
//	| block
	| text
	;

tag : HASH ID (COLON value)?;
value : ID;
link : HTTP WORD;
text : ID | NUMBER | WORD | SPACE | HASH SPACE | COLON;

// LEXER



HASH : '#';
COLON : ':';
HTTP : 'http://' | 'https://';
ID : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'.')*;
NUMBER : ('0'..'9')+ ('.'('0'..'9')+)?;
SPACE : [ \r\t\n]+;
WORD : ~(' '|'\r'|'\t'|'\n'|'#'|':')+;
