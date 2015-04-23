/**
    8.27    n!  (factorial of n)
    How about if n is very big?
    If 99% of n! is between 400000 and 900000, how to improve the speed of computation?
 */

package question8_27;

public class Question {

    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
        
    }
    
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

}
