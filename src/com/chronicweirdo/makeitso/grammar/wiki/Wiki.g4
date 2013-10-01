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

tag : HASH WORD (COLON value)?;
value : WORD;
link : 'http' WORD;
text : WORD | SPACE | HASH SPACE | COLON SPACE;

// LEXER

//ID : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'.')*;
//NUMBER : ('0'..'9')+ ('.'('0'..'9')+)?;

SPACE : [ \r\t\n]+;
HASH : '#';
COLON : ':';
WORD : ~(' '|'\r'|'\t'|'\n'|'#'|':')+;
