// Define a grammar called Hello
grammar Hello;
r  : 'hello' ID {System.out.println("first term");};         // match keyword hello followed by an identifier
ID : [a-z]+      {System.out.println("id: ");} ;       // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines