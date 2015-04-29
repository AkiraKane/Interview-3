/**
    3.3     Describe how you could use a single array to implement three stacks.  
    (CareerCups150 - 3.1)
 */
package question3_3;

public class Question {

    public static void main(String[] args) {
        MyArrayStacks myStack = new MyArrayStacks();
        myStack.push(2,4);
        System.out.println("Peek 2: " + myStack.peek(2));
        
        myStack.push(0,3);
        myStack.push(0,7);
        myStack.push(0,5);
        System.out.println("Peek 0: " + myStack.peek(0));
        myStack.pop(0);
        System.out.println("Peek 0: " + myStack.peek(0));
        myStack.pop(0);
        System.out.println("Peek 0: " + myStack.peek(0));
    }
}
