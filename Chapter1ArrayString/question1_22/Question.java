/**
    1.22    Implement strstr(). Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    (CleanCodeHandbook--5)
    (leetcode28)
    (leetcodecpp3.2)
 */

package question1_22;

public class Question {
    
    public int strstr(String haystack, String needle) {
        for(int i=0; i<haystack.length(); i++){
            for(int j=0; j<needle.length(); j++){
                if(j==needle.length()) {
                    return i;
                }
                if(i+j==haystack.length()){
                    return -1;
                }
                if(needle.charAt(j)!=haystack.charAt(i+j)){
                    break;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {

    }

}
