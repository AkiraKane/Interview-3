/**
    1.42    Distinct Subsequences
    Given a string S and a string T, count the number of distinct subsequences of T in S.
    A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
    Here is an example:
    S = "rabbbit", T = "rabbit"
    Return 3.
    (leetcode115)
    (leetcodecpp13.11)
 */
package question1_42;

public class Question {

    public static int distinct(String S, String T){
        if(T.equals("")){
            return 1;
        }
        char c = T.charAt(0);
        // find c in S
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)==c){
                // choose to include this character or not
                return distinct(S.substring(i+1), T.substring(1)) + distinct(S.substring(i+1), T);
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        String S = "rabbbit";
        String T = "rabbit";
        System.out.println(distinct(S, T));
    }

}
