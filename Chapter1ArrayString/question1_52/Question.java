/**
    1.52    Length of Last Word
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
    If the last word does not exist, return 0.
    Note: A word is defined as a character sequence consists of non-space characters only.
    For example,
    Given s = "Hello World",
    return 5.
    (leetcode58)
    (leetcode3.15)
 */
package question1_52;

public class Question {

    public static int lengthOfLastWord(String input){
        if(input.charAt(input.length()-1)==' '){
            return 0;
        }
        int length = 1;
        for(int i=input.length()-2; i>=0; i--){
            char c = input.charAt(i);
            if(c==' '){
                return length;
            } else {
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

}
