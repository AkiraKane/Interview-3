/**
    8.8     Prime number
    a) Check if a given number is prime number
    (CareerCups150 -- P98)
    Output all prime numbers up to a specified integer n.
    http://www.leetcode.com/2010/04/finding-prime-numbers.html
 */

package question8_8;

public class Question {

    public static boolean isPrime(int n) {
        if(n==1 || n==2){
            return true;
        }
        for(int i=2; i<n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    

    public static void main(String[] args) {
        System.out.println(isPrime(12));
    }

}
