/**
    1.15    Find the longest palindrome inside a string
    Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
    (CleanCodeHandbook--13)
    (leetcode5)
    (leetcodecpp3.5)
    http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-i.html
    http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
 */
package question1_15;

public class Question {

    public String longestPalindrome(String s){
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start, end+1);
    }
    
    public int expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        while(L>=0 && R<s.length() && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;  // ???
    }
    
    
    public static void main(String[] args) {

    }

}
