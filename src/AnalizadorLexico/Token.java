/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorLexico;

public class Token {

    private TokenType type;
    private String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    // Getters and setters for type and value
    @Override
    public String toString() {
        return "Token{"
                + "type=" + type
                + ", value='" + value + '\''
                + '}';
    }

    public enum TokenType {
        IDENTIFIER, // for variables, function names, etc.
        NUMBER, // for numeric literals
        PLUS, // for the plus operator
        MINUS,      // for the minus operator
        // Define more token types as needed
    }
}
