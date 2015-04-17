/**
    8.9     Write a function to swap two numbers in place without temporary variables
    (CareerCups150 -- 17.1)
 */

package question8_9;

public class Question {
    // swap with temporary variable
    public static void swap_with_temporary_variable(int a, int b){
        int swap = a;
        a = b;
        b = swap;
        
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
    
    // method 1 without temporary variable
    public static void swap(int a, int b){
        a = a^b;
        b = a^b;
        a = a^b;
        
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
    
    // method 2 without temporary variable
    public static void swap_1(int a, int b){
        a = a+b;
        b = a-b;
        a = a-b;
        
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
    
    
    public static void main(String[] args) {
        int a = 1672;
        int b = 9332;
        
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        
        swap(a, b);
    }

}
