/**
    1.25    Minimum window substring
    Finding the minimum Window in S which contains all elements from T.
    Given a set T of characters and a string S, find the minimum window in S which will contain all the characters in T in complexity O(n).
    eg,
    S = “ADOBECODEBANC”
    T = “ABC”
    Minimum window is “BANC”.
    Note:
    If there is no such window in S that covers all characters in T, return the emtpy string "".
    If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
    (leetcode76)
    (leetcodecpp15.5)
    http://www.leetcode.com/2010/11/finding-minimum-window-in-s-which.html
 */

package question1_25;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Question {
    
    
    public static String minimumWindow(String S, String T){
        String minWindow ="";
        
        Set<Character> charOfT = new HashSet<Character>();
        for(char c : T.toCharArray()){
            charOfT.add(c);
        }
        
        HashMap<Character, Integer> numToFound = new HashMap<Character, Integer>();
        for(char c : T.toCharArray()){
            if(numToFound.containsKey(c)){
                numToFound.put(c, numToFound.get(c)+1);
            } else {
                numToFound.put(c, 1);
            }
        }
        
        HashMap<Character, Integer> numHasFound = new HashMap<Character, Integer>();
        // the windows starts from the whole S
        for(char c : S.toCharArray()){
            if(charOfT.contains(c)){
                if(numHasFound.containsKey(c)){
                    numHasFound.put(c, numHasFound.get(c)+1);
                } else {
                    numHasFound.put(c, 1);
                }
            }
        }
        
        // check if S contains T
        for(char c : charOfT){
            if(numHasFound.get(c)<numToFound.get(c)){
                // fail, return ""
                return "";
            }
        }
        
        int left = 0;
        int right = S.length()-1;
        
        // left pointer doesn't move, try to move right pointer as left as possible
        for(int i=S.length()-1; i>=left; i--){
            char thisChar = S.charAt(i);
            if(charOfT.contains(thisChar)){
                if(numHasFound.get(thisChar)-1 < numToFound.get(thisChar)){
                    // right pointer stops here
                    right=i;
                    break;
                } else {
                    numHasFound.put(thisChar, numHasFound.get(thisChar)-1);
                }
            }
        }
        
        // now try to move left pointer as right as possible
        for(int i=0; i<=right; i++){
            char thisChar = S.charAt(i);
            if(charOfT.contains(thisChar)){
                if(numHasFound.get(thisChar)-1 < numToFound.get(thisChar)){
                    // left pointer stops here
                    left=i;
                    break;
                } else {
                    numHasFound.put(thisChar, numHasFound.get(thisChar)-1);
                }
            }
        }
        
        System.out.println(left + "," + right);
        
        int minWindowSize = (right-left);
        for(int i=left; i<=right; i++){
            minWindow+=S.charAt(i);
        }
        
        
        numHasFound = new HashMap<Character, Integer>();
        // the windows starts from the whole S
        for(char c : S.toCharArray()){
            if(charOfT.contains(c)){
                if(numHasFound.containsKey(c)){
                    numHasFound.put(c, numHasFound.get(c)+1);
                } else {
                    numHasFound.put(c, 1);
                }
            }
        }
        
        left = 0;
        right = S.length()-1;
        // now move left pointer to right first
        for(int i=0; i<=right; i++){
            char thisChar = S.charAt(i);
            if(charOfT.contains(thisChar)){
                if(numHasFound.get(thisChar)-1 < numToFound.get(thisChar)){
                    // left pointer stops here
                    left=i;
                    break;
                } else {
                    numHasFound.put(thisChar, numHasFound.get(thisChar)-1);
                }
            }
        }
        
        // now move right pointer to left 
        for(int i=S.length()-1; i>=left; i--){
            char thisChar = S.charAt(i);
            if(charOfT.contains(thisChar)){
                if(numHasFound.get(thisChar)-1 < numToFound.get(thisChar)){
                    // right pointer stops here
                    right=i;
                    break;
                } else {
                    numHasFound.put(thisChar, numHasFound.get(thisChar)-1);
                }
            }
        }
        
        System.out.println(left + "," + right);
        if((right-left)<minWindowSize){
            minWindowSize = (right-left);
            minWindow="";
            for(int i=left; i<=right; i++){
                minWindow+=S.charAt(i);
            }
        }
        
        return minWindow;
        
    }
    
    
    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        
        System.out.println(minimumWindow(S, T));
        
    }

}
