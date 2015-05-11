/**
    1.26    Find Longest Common Substring
    http://en.wikipedia.org/wiki/Longest_common_substring_problem
    Dynamic Programming
 */

package question1_26;

public class Question {


    // brute force solution
    public static String longestCommonSubstring1(String str1, String str2){
        String longestCommonSubstring = "";

        for(int i=0; i<str1.length(); i++){
            for(int j=0; j<str2.length(); j++){
                // str1 starts from position i
                // str2 starts from position j
                // find the longest common substring
                String currentLongest = findLongestSubstring(str1, str2, i, j);
                if(currentLongest.length()>longestCommonSubstring.length()){
                    longestCommonSubstring=currentLongest;
                }
            }
        }
        return longestCommonSubstring;
    }

    public static String findLongestSubstring(String str1, String str2, int start1, int start2){
        StringBuilder sb = new StringBuilder();
        int index1 = start1;
        int index2 = start2;
        while(index1<str1.length() && index2<str2.length()){
            if(str1.charAt(index1)==str2.charAt(index2)){
                sb.append(str1.charAt(index1));
                index1++;
                index2++;
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    // faster solution: dynamic programming
    public static String longestCommonSubstring2(String str1, String str2){
        int[][] result = new int[str1.length()][str2.length()];
        int max = 0;
        String longestSubstring = "";
        for(int i=0; i<str1.length(); i++){
            for(int j=0; j<str2.length(); j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    if(i==0 || j==0){
                        result[i][j]=1;
                    } else {
                        result[i][j] = result[i-1][j-1]+1;
                    }
                    if(result[i][j]>max){
                        max=result[i][j];
                        longestSubstring = str1.substring(i-max+1, i+1);
                    }
                }
            }
        }
        return longestSubstring;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubstring1("abcdefg", "eabckl") + " | "+longestCommonSubstring2("abcdefg", "eabckl"));
    }
}
