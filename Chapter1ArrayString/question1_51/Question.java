/**
    1.51     Count and say
    The count-and-say sequence is the sequence of integers beginning as follows:
    1, 11, 21, 1211, 111221, ...
    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.
    Given an integer n, generate the nth sequence.      
    Note: The sequence of integers will be represented as a string.
    (leetcode38)
    (leetcodecpp3.12)
 */

package question1_51;

public class Question {

    public static String countAndSay(int n){
        String result = "";
        int lastDigit = n%10;
        int count = 0;
        while(n>0){
            int digit = n%10;
            n /= 10;
            if(digit==lastDigit){
                count++;
            } else {
                result = Integer.toString(count)+Integer.toString(lastDigit)+result;
                count=1;
                lastDigit=digit;
            }
        }
        result=Integer.toString(count)+Integer.toString(lastDigit)+result;
        return result;
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(countAndSay(21));
        System.out.println(countAndSay(11221));
    }
}