/**
    3.11    Valid Parentheses
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
    (CleanCodeHandbook--41)
    (leetcode20)
    (leetcodecpp4.1.1)
 */
package question3_11;

import java.util.HashMap;
import java.util.Stack;

public class Question {
    
    public static boolean isValidParentheses(String input) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        
        Stack<Character> stack = new Stack<Character>();
        for(char c : input.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            } else if(stack.isEmpty() || map.get(stack.pop())!=c){
                    return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String input = "{{}}";
        System.out.println(isValidParentheses(input));
    }

}
