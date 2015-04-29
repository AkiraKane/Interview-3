package question3_8;

import java.util.Stack;

public class MyQueue<T> {
    
    Stack<T> stackNewest, stackOldest;
    
    public MyQueue() {
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }
    
    public void add(T value){
        stackNewest.push(value);
    }
    
    public T remove() {
        shiftStacks();
        return stackOldest.pop();
    }
    
    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }
    
    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    private void shiftStacks() {
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }
    
}
