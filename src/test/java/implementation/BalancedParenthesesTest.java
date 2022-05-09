package implementation;

import org.junit.Test;

import static org.junit.Assert.*;



public class BalancedParenthesesTest {
    @Test
    public void testBalanced() {
        String input = "{[()]}";
        Boolean solve = new BalancedParentheses(input).solve();
        assertNotNull(solve);
        assertTrue(solve);
    }

    @Test
    public void testNonBalanced() {
        String input = "{[(])}";
        Boolean solve = new BalancedParentheses(input).solve();
        assertNotNull(solve);
        assertFalse(solve);
    }

    @Test
    public void testOddCountOfParentheses() {
        String input = "{(()}";
        Boolean solve = new BalancedParentheses(input).solve();
        assertFalse(solve);
    }

    @Test
    public void testClosingParenthesesOnly() {
        String input = "])}";
        Boolean solve = new BalancedParentheses(input).solve();
        assertFalse(solve);
    }

    @Test
    public void testOpeningParenthesesOnly() {
        String input = "(((";
        Boolean solve = new BalancedParentheses(input).solve();
        assertFalse(solve);
    }

    @Test
    public void testMixedLongInput() {
        String input = "([{{[(())]}}])";
        Boolean solve = new BalancedParentheses(input).solve();
        assertNotNull(solve);
        assertTrue(solve);
    }

    @Test
    public void testEmptyInput() {
        String input = "";
        Boolean solve = new BalancedParentheses(input).solve();
        assertNotNull(solve);
        assertTrue(solve);
    }

    @Test
    public void testNullAsInput() {
        Boolean solve = new BalancedParentheses(null).solve();
        assertFalse(solve);
    }

}