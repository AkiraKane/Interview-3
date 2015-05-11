/**
    1.40    Find Longest Common Subsequence
    http://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 */
package question1_40;

public class Question {


    // find the length of longest common subsequence
    // dynamic programming
    public static int longestCommonSubsequence(String str1, String str2){

        int[][] store = new int[str1.length()+1][str2.length()+1];
        for(int i=0; i<=str2.length(); i++){
            store[0][i] = 0;
        }
        for(int i=0; i<=str1.length(); i++){
            store[i][0] = 0;
        }
        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    store[i][j] = store[i-1][j-1]+1;
                } else {
                    store[i][j] = Math.max(store[i][j-1], store[i-1][j]);
                }
            }
        }
        return store[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        String str1 = "agcat";
        String str2 = "gac";
        System.out.println(longestCommonSubsequence(str1, str2));
    }
}
