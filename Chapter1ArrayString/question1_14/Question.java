/**
    1.14    Check if a String is palindrome
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.       
    For example,
    "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.
    Example Questions Candidate Might Ask:                                                      
    Q: What about an empty string? Is it a valid palindrome?
    A: For the purpose of this problem, we define empty string as valid palindrome.
    (CleanCodeHandbook--4)
    (leetcode125)
    (leetcodecpp3.1)
 */
package question1_14;

public class Question {

    public static boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    
    public static void main(String[] args) {

    }

}
