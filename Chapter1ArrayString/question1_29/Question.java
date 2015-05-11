/**
    1.29    Substring with Concatenation of All Words
    You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
    For example, given:
    S: "barfoothefoobarman"
    L: ["foo", "bar"]
    You should return the indices: [0,9].
    (order does not matter).
    (leetcode30)
    (leetcodecpp15.7)
 */

package question1_29;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Question {

    public static List<Integer> getIndices(String input, String[] words){
        List<Integer> result = new ArrayList<Integer>();

        HashSet<String> set = new HashSet<String>();
        for(String word : words){
            set.add(word);
        }
        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        for(int i=0; i<=(input.length()-totalLength); i++){
            if(isConcatenation(input.substring(i, i+totalLength), wordLength, (HashSet<String>)set.clone())){
                result.add(i);
            }
        }
        return result;
    }

    public static boolean isConcatenation(String input, int wordLength, HashSet<String> set){
        for(int i=0; i<=(input.length()-wordLength); i=(i+3)){
            String word = input.substring(i, i+wordLength);
            if(set.contains(word)){
                set.remove(word);
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String input = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> result = getIndices(input, words);
        for(Integer index : result){
            System.out.println(index);
        }
    }
}
