/**
 * 1.10 Given two strings, write a method to decide if one is a permutation of the others. 
 * (CareerCups150--1.3)
 */


package question1_10;

import java.util.Arrays;

public class Question { 
    // sort string and check if equal
    public static boolean isPermutation_method1(String s, String t) {
        if(s.length()!=t.length()) return false;
        return sort(s).equals(sort(t));
    }
    
    public static String sort(String original){
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    //  check if two strings have same number of same characters
    public static boolean isPermutation_method2(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] numbers1 = numbers(s);
        int[] numbers2 = numbers(t);
        for(int i=0; i<numbers1.length;i++){
            if(numbers1[i]!=numbers2[i]){
                return false;
            }
        }
        return true;
    }
    
    public static int[] numbers(String str){
        int[] numbers = new int[128];
        char[] chars = str.toCharArray();
        for(int i=0; i<chars.length;i++){
            int position = str.charAt(i);
            numbers[position]++;
        }
        return numbers;
    }
    
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean check1 = isPermutation_method1(word1, word2);
            boolean check2 = isPermutation_method2(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + check1 + " | " + check2);
        }
    }
}
