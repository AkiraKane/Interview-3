/**
    3.4     Min Stack
    How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element? Push, pop and min should all operate in O(1) time.
    (CareerCups150 - 3.2)
    
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    push(x) – Push element x onto stack.
    pop() – Removes the element on top of the stack.
    top() – Get the top element.
    getMin() – Retrieve the minimum element in the stack.
    (CleanCodeHandbook--39)
    (leetcode155)
    http://articles.leetcode.com/2010/11/stack-that-supports-push-pop-and-getmin.html
 */
package question3_4;

import CtCILibrary.AssortedMethods;

public class Question {

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        
        for(int i=0; i<15; i++){
            int value = AssortedMethods.randomIntInRange(0, 100);
            stack.push(value);
        }
        System.out.println();
        for(int i=0; i<15;i++){
            System.out.println("Popped "+stack.pop());
            System.out.println("New min is "+stack.min());
        }
    }
}
