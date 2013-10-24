grammar Mediawiki;
@header
{
package com.chronicweirdo.makeitso.grammar.mediawiki;
}


page : section+;

section
	: template
	;

template : '{{' templateName templateProperty+ '}}' ;
templateName : TEXT ;
templateProperty : '|' templatePropertyName '=' templatePropertyValue ;
templatePropertyName : TEXT ;
templatePropertyValue : TEXT ;

TEXT : ~[\r\n|={]+ ;
WS : [\r\n]+ -> channel(HIDDEN);