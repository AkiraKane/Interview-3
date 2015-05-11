/**
    1.27    Longest common Prefix
    Write a function to find the longest common prefix string amongst an array of strings.
    (leetcode14)
    (leetcodecpp3.8)
 */

package question1_27;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public static String longestCommonPrefix(List<String> strings){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strings.get(0).length(); i++){
            char c = strings.get(0).charAt(i);
            for(int j=1; j<strings.size(); j++){
                String s = strings.get(j);
                if(s.length()<(i+1) || s.charAt(i)!=c){
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        strings.add("abcde");
        strings.add("abc");
        strings.add("abchij");
        System.out.println(longestCommonPrefix(strings));
    }

}
