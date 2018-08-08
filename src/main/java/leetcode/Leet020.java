package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 * 
 * Link: https://leetcode.com/problems/valid-parentheses/description/
 * 
 * @author abijwe
 */
public class Leet020 {

    private static Map<Character, Character> openBrackets = new HashMap<Character, Character>()
    {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
    }};
    private Set<Character> closeBrackets = new HashSet<>(Arrays.asList('}', ']', ')'));

    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (openBrackets.containsKey(c)) {
                brackets.push(openBrackets.get(c));
            } else if (closeBrackets.contains(c)) {
                if (brackets.isEmpty()) {
                    return false;
                }
                char onStack = brackets.pop();
                if (c != onStack) {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}
