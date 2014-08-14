package org.chronicweirdo.javapuzzlers.chapter3.puzzle14;

public class EscapeRout {
    public static void main(String[] args) {
        // \u0022 is the Unicode escape for double-quote (")
        System.out.println("a\u0022.length() + \u0022b".length());
        // will print the length of >>a".length() + "b<< which is 16
        // and it prints 2 ...
        // java provides no special treatment for unicode escapes within string literals
        // compiler translates unicode escapes into the character literals before it parses the program into tokens
        // java supports octal escape sequences, starting with \\
    }
}
