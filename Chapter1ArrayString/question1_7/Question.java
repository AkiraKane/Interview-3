/**
    1.7      Give an input string s, reverse the string word by word.
    For example, give s=”the sky is blue”, return “blue is sky the”
    (CleanCodeHandbook--6)
    (leetcode151)
    Similar to the above question, but with the following constraints: “The input string does not contain leading or trailing spaces and the words are always separated by a single space.”
    Could you do it in-place without allocating extra space?
    (CleanCodeHandbook--7)
 */


package question1_7;

public class Question {

    
    
    
    // solution to the second part
    // "abc def gdf"
    public static void reverseWords(char[] s){
        reverse(s, 0, s.length-1);
        for(int i=0, j=0; j<=s.length; j++){
            if(j==s.length || s[j]==' '){
                reverse(s, i, j-1);
                i=j+1;
            }
        }
    }
    
    public static void reverse(char[] s, int begin, int end){
        int i = begin;
        int j = end;
        while(i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
