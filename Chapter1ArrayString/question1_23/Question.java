/**
    1.23    Longest Substring without repeating characters.
    Given a string, find the length of the longest substring without repeating characters.
    For example, the longest substring without repeating letters for “abcabcbb” is “abc”, which the length is 3. For “bbbbb” the longest substring is “b”, with the length of 1.
    (CleanCodeHandbook--10)
    (leetcode3)
    (leetcodecpp12.5)
 */

package question1_23;

import java.util.HashMap;

public class Question {

    public static String longestSubstring(String str){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        String maxSubstring="";
        map.put(str.charAt(0), 0);
        for(int i=1; i<str.length(); i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c)<start){
                    map.put(c, i);
                } else {
                    int currentMax =(i-start);
                    if(currentMax>maxSubstring.length()){
                        end = i;
                        maxSubstring = str.substring(start, end);
                    }
                    start = map.get(c)+1;
                    map.put(c, i);
                }
            } else {
                map.put(c, i);
            }
        }
        if((str.length()-start)>maxSubstring.length()){
            end = str.length();
            maxSubstring=str.substring(start, end);
        }
        return maxSubstring;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("abcabcbb"));
        System.out.println(longestSubstring("bbbb"));
    }
}
