/**
 * Implement stack
 * (CareerCups150 -- P79)
 */

package question3_1;

public class Question {

    public static void main(String[] args) {
        Stack stack = new Stack();
        for(int i=0;i<10;i++){
            stack.push(i);
        }
        stack.print();
        
        stack.pop();
        stack.print();
    }
}
