grammar Wiki;
@header
{
package com.chronicweirdo.makeitso.grammar.wiki;
}

page : (section)+;

section
	: block
	| link
	| tag
	| text
	;

tag : HASH ID (COLON value)?;
value : ID;
link : HTTP WORD;
block : blockOpen blockContents blockClose;
blockOpen : LT blockOpenContents+ GT;
blockOpenContents
	: tag
	| text
	;
blockContents : section*? ;
blockClose : BEND;
text : ID | NUMBER | WORD | SPACE | HASH SPACE | COLON | LT | GT | BEND;

// LEXER



HASH : '#';
COLON : ':';
LT : '<';
GT : '>';
BEND : '</>';
HTTP : 'http://' | 'https://';
ID : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'.')*;
NUMBER : ('0'..'9')+ ('.'('0'..'9')+)?;
SPACE : [ \r\t\n]+;
WORD : ~(' '|'\r'|'\t'|'\n'|'#'|':'|'>'|'<')+;
