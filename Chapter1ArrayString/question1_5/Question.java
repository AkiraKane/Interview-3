/**
    1.5     A String Replacement Problem
    Replace all occurrence of the given pattern to ‘X’.
    For example, given that the pattern=”abc”, replace “abcdeffdfegabcabc” with “XdeffdfegX”. Note that multiple occurrences of abc’s that are contiguous will be replaced with only one ‘X’.
    http://www.leetcode.com/2010/11/microsoft-string-replacement-problem.html
 */

package question1_5;

public class Question {
    public static void replacePattern(String a, String pattern){
        char[] chars = a.toCharArray();
        int slow = 0;
        int runner = 0;
        while(runner<chars.length){
            boolean match = false;
            while(isMatched(chars, runner, pattern)){
                runner += pattern.length();
                match = true;
            }
            if(match==true){
                chars[slow++] = 'X';
            }
            if(runner<chars.length){
                chars[slow++]=chars[runner++];
            }
        }
        
        for(int i=0; i<slow; i++){
            System.out.print(chars[i]);
        }
    }
    
    public static boolean isMatched(char[] chars, int runner, String pattern){
        for(int i=0; i<pattern.length(); i++){
            if((runner+i)>=chars.length || chars[runner+i]!=pattern.charAt(i)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        replacePattern("abcdeffdfegabcabc", "abc");
    }
}
