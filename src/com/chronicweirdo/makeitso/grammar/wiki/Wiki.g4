grammar Wiki;
@header
{
package com.chronicweirdo.makeitso.grammar.wiki;
}

page : (section)+;

section
	: tag
//	| link
//	| block
	| text;

tag : '#' ID (':' ID)? ;
text : ANY+? ;

// LEXER

ID : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'.')*;

NUMBER : ('0'..'9')+ ('.'('0'..'9')+)?;

ANY : .;