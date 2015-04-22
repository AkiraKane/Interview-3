/**
    6.3     Get all permutation of a String.
    (CareerCups150 -- 9.5)
     
    Permutation
    Given a collection of numbers, return all possible permutations.
    For example,
    [1,2,3] have the following permutations:
    [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
    (leetcode46)
    (leetcodecpp8.3)
     
    Permutation II
    Given a collection of numbers that might contain duplicates, return all possible unique permutations.
    For example,
    [1,1,2] have the following unique permutations:
    [1,1,2], [1,2,1], and [2,1,1].
    (leetcode47)
    (leetcodecpp8.4)
 */

package question6_3;

import java.util.ArrayList;

public class Question {
    
    // no duplicate characters in the string
    public static ArrayList<String> getPerms(String str, int index) {
        if(str==null) {
            return null;
        }
        ArrayList<String> permutations = new ArrayList<String>();
        if(index<0){
            permutations.add("");
            return permutations;
        }
        char first = str.charAt(index);
        ArrayList<String> words = getPerms(str, index-1);
        for(String word : words){
            for(int i=0; i<=word.length();i++){
                String s = insertCharAt(word, first, i);
                permutations.add(s);
            }
        }
        return permutations;
    }
    
    public static String insertCharAt(String word, char c, int i){
        return word.substring(0,i) + c + word.substring(i);
    }
    
    public static void main(String[] args) {
        ArrayList<String> list = getPerms("abcde", "abcde".length()-1);
        System.out.println("There are " + list.size() + " permutations");
        for(String s : list){
            System.out.println(s);
        }
    }
}
