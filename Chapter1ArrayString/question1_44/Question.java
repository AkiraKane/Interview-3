/**
    1.44    Find whether one string is a subsequence of another string. (not need to be contiguous, but the order should match).
 */
package question1_44;

public class Question {
    
    public static boolean isSubsequence(String a, String b){
        return subsequence(a, b, 0, 0);
    }
    
    public static boolean subsequence(String a, String b, int start, int position){
        if(position>=b.length()) return true;
        
        char charToFind = b.charAt(position);
        for(int i=start;i<a.length(); i++){
            if(a.charAt(i)==charToFind){
                if(subsequence(a, b, i+1, position+1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "abcdefg";
        String b = "bdk";
        System.out.println(isSubsequence(a, b));
    }

}
