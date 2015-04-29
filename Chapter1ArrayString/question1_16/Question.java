/**
    1.16    Palindrome Partitioning
    Given a string s, partition s such that every substring of the partition is a palindrome.
    Return all possible palindrome partitioning of s.
    For example, given s = "aab",
    Return
      [     ["aa","b"],     ["a","a","b"]   ]
    (leetcode131)
    (leetcodecpp10.1)
     
    Given a string s, partition s such that every substring of the partition is a palindrome.
    Return the minimum cuts needed for a palindrome partitioning of s.
    For example, given s = "aab",
    Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
    (leetcode132)
    (leetcodecpp13.3)
 */
package question1_16;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public static List<List<String>> palindromePartition(String input){
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        DFS(input, path, result, 0);
        return result;
    }
    
    public static void DFS(String s, List<String> path, List<List<String>> result, int start) {
        if(start==s.length()){
            result.add(path);
            return;
        }
        for(int i=start; i<s.length(); i++){
            if(isPalindrome(s, start, i)){
                List<String> newPath = new ArrayList<String>();
                newPath.addAll(path);
                newPath.add(s.substring(start, i+1));
                DFS(s, newPath, result, i+1);
            }
        }
    } 
    
    private static boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        String input = "aab";
        List<List<String>> result = palindromePartition(input);
        for(List<String> path : result){
            for(String item : path){
                System.out.print(item+" ");
            }
            System.out.println();
        }
    }

}
