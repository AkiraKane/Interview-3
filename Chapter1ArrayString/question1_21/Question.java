/**
 *   1.21    isSubstring
 *   Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (i e , “waterbottle” is a rotation of “erbottlewat”)
 *   (CareerCups150--1.8)
 */

package question1_21;

public class Question {
    public static boolean isRotation(String s1, String s2){
       if(s1.length()!=s2.length()) return false;
       String s1s1 = s1+s1;
       return s1s1.contains(s2);
    }
    
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation); 
        }
    }
}
