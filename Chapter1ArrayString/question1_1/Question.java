/**
 * 1.1 Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures?
 * (CareerCups150--1.1)
 * 
 */

package question1_1;

public class Question {
    // no additional storage solution
    // use 
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }
    
    // use char_set as additional 
    public static boolean isUniqueChars2(String str) {
        if(str.length()>128){
            return false;
        }
        boolean[] charSet = new boolean[128];
        for(int i=0; i<str.length();i++){
            int position = str.charAt(i);
            if(charSet[position]) return false;
            charSet[position]=true;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println((int)'a');
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word));
        }
    }
}
