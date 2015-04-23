/**
    8.28    Fibonacci Numbers (Iterative and Recursive)
    (CareerCups150 -- P108)
    http://algoriddles.wordpress.com/category/dynamic-programming/
 */

package question8_28;

public class Question {

    // recursive solution
    public static int fibonacci(int n) {
        if(n==0){
            return 0;
        } else if(n==1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    
    // iterative solution
    public static int fibonacci_iterative(int n){
        if(n==0){
            return 0;
        } else if(n==1){
            return 1;
        }
        
        int last = 0;
        int middle = 1;
        int current = 0;
        for(int i=2; i<=n; i++){
            current = last+middle;
            last = middle;
            middle = current;
        }
        return current;
    }
    
    public static void main(String[] args) {
        System.out.println(fibonacci(5)+" "+fibonacci_iterative(5));
    }
}
