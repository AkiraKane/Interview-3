/**
    6.5     Letter combinations of a phone number
    Given a digit string, return all possible letter combinations that the number could represent.
    A mapping of digit to letters (just like on the telephone buttons) is given below.
    
    Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    Note:
    Although the above answer is in lexicographical order, your answer could be in any order you want.
    (leetcode17)
    (leetcodecpp8.6)
 */

package question6_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question {

    public static void combination(String input, int position, String output, HashMap<Character, String> phone, List<String> result){
        if(position==input.length()){
            result.add(output);
            return;
        }
        char digit = input.charAt(position);
        String letters = phone.get(digit);
        for(int i=0; i<letters.length(); i++){
            char letter = letters.charAt(i);
            combination(input, position+1, output+letter, phone, result);
        }
    }
    
    
    public static void main(String[] args) {
        HashMap<Character, String> phone = new HashMap<Character, String>();
        phone.put('2', "abc");
        phone.put('3', "def");
        
        List<String> result = new ArrayList<String>();
        combination("23", 0, "", phone, result);
        
        for(String element : result){
            System.out.println(element);
        }
        
        
    }

}
