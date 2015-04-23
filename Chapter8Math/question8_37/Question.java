/**
    8.37    Happy Number
    Write an algorithm to determine if a number is "happy".
    A happy number is a number defined by the following process: 
    Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), 
    or it loops endlessly in a cycle which does not include 1. 
    Those numbers for which this process ends in 1 are happy numbers.
    Example: 19 is a happy number
        1^2 + 9^2 = 82
        8^2 + 2^2 = 68
        6^2 + 8^2 = 100
        1^2 + 0^2 + 0^2 = 1
    (leetcode202)
 */

package question8_37;

public class Question {
    public static boolean isHappy(int n){
        int num = n;
        int count = 0;
        while(num!=1){
            System.out.println(num);
            if(count>=10){
                return false;
            }
            count++;
            int oldnum = num;
            num=0;
            while(oldnum!=0){
                int newDigit = oldnum%10;
                num+=newDigit*newDigit;
                oldnum=oldnum/10;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

}
