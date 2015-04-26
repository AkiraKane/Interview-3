/**
    3.12    Longest Valid Parentheses
    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
    For "(()", the longest valid parentheses substring is "()", which has length = 2.
    Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
    (leetcode32)
    (leetcodecpp4.1.2)
 */
package question3_12;

import java.util.HashMap;
import java.util.Stack;


public class Question {

    public static int longestValidParenthese(String input) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        
        int longestLength = 0;
        int length = 0;
        boolean isValid = false;
        Stack<Character> stack = new Stack<Character>();
        for(char c : input.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            } else if(!stack.isEmpty()){
                if(map.get(stack.pop())==c){
                    if(isValid==false){
                        isValid=true;
                    }
                    length+=2;
                    if(length>longestLength){
                        longestLength=length;
                    }
                } else {
                    length=0;
                    isValid=false;
                }
            }
        }
        
        return longestLength;
    }
    
    
    public static void main(String[] args) {
        String input = ")()())";
        System.out.println(longestValidParenthese(input));
    }

}
