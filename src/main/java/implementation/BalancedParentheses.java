package implementation;

import interfaces.Solvable;

import java.util.Stack;


/**
 * This program checks if parentheses are balanced or not
 *
 * @author Pepi Zlatev
 * @since 09.05.2022
 */
public class BalancedParentheses implements Solvable {

    //Create Stack
    private Stack<Character> stack = new Stack<>();

    //Create String Object
    private String parentheses;

    /**
     * Constructor
     *
     * @param parentheses - String Object
     */
    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    /**
     * This method solves the problem
     *
     * @return - True, if the Parentheses are balanced, else False
     */
    @Override
    public Boolean solve() {

        //Checks if the input is null - in this case returns false
        if (this.parentheses == null) {
            return false;
        }

        //Checks if the length of the input is even or odd.
        //If it is odd, then the parentheses are not balanced.
        if (this.parentheses.length() % 2 != 0) {
            return false;
        }

        //Checks if the input is an empty String.
        //If so, returns true
        if (this.parentheses.isEmpty()) {
            return true;
        }

        char firstCharacter = this.parentheses.charAt(0);

        //Checks if the first character is a closing parenthesis.
        //If so, returns false.
        if (firstCharacter == '}' || firstCharacter == ']' || firstCharacter == ')') {
            return false;
        }

        for (int i = 0; i < this.parentheses.length(); i++) {
            firstCharacter = this.parentheses.charAt(i);

            //Checks if the current parenthesis is an opening one.
            //If so, then this parenthesis is added to the stack.
            if (firstCharacter == '{' || firstCharacter == '(' || firstCharacter == '[') {
                stack.push(firstCharacter);
                continue;
            }

            char topChar = stack.pop();

            //Calls the isBalanced method to check the parenthesis.
            if (!isBalanced(firstCharacter, topChar)) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    /**
     * Method that checks if the current parenthesis
     * and the one on the top on the stack are pari.
     *
     * @param currentChar - The current parenthesis
     * @param topChar     - The parenthesis on the top on the stack
     * @return - True, if the both parentheses are pair, else False
     */
    public boolean isBalanced(char currentChar, char topChar) {
        return switch (topChar) {
            case '{' -> currentChar == '}';
            case '(' -> currentChar == ')';
            case '[' -> currentChar == ']';
            default -> false;
        };
    }

}
