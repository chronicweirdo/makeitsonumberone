grammar Mediawiki;
@header
{
package com.chronicweirdo.makeitso.grammar.mediawiki;
}


template : '{{' templateName templateProperty+ '}}' ;
templateName : text ;
templateProperty : '|' templatePropertyName '=' templatePropertyValue ;
templatePropertyName : text ;
templatePropertyValue : text ;

text : (SPACE | WORD)+ ;

SPACE : [ \r\t\n]+;
WORD : ~(' '|'\r'|'\t'|'\n'|'{'|'}'|'|'|'=')+;