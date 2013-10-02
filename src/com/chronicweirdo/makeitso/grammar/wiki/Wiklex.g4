lexer grammar Wiklex;
@header
{
package com.chronicweirdo.makeitso.grammar.wiki;
}

HASH : '#';
COLON : ':';
LT : '<';
GT : '>';
HTTP : 'http://' | 'https://';
NS : '/';
ID : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'.')*;
NUMBER : ('0'..'9')+ ('.'('0'..'9')+)?;
SPACE : [ \r\t\n]+;
WORD : ~(' '|'\r'|'\t'|'\n'|'#'|':'|'>'|'<')+;
