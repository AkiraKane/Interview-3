/**
    1.28    Find Longest Increasing substring
    http://codingplayground.blogspot.com/2011/01/find-longest-increasing-substring.html
 */

package question1_28;

public class Question {

    public static String findLongestIncreasingSubstring(String str){
        String longestSubstring = "";
        int start=0;
        for(int i=1; i<str.length(); i++){
            char c = str.charAt(i);
            if(c<str.charAt(i-1)){
                String current = str.substring(start, i);
                if(current.length()>longestSubstring.length()){
                    longestSubstring = current;
                    start = i;
                }
            }
        }
        if(str.substring(start, str.length()).length()>longestSubstring.length()){
            longestSubstring = str.substring(start, str.length());
        }
        return longestSubstring;
    }

    public static void main(String[] args) {
        System.out.println(findLongestIncreasingSubstring("212343"));
    }

}
