package question3_1;

import java.util.EmptyStackException;

import CtCILibrary.LinkedListNode;

public class Stack {
    private LinkedListNode top;
    
    public Stack(){
        top = null;
    }
    
    public void push(int n) {
        LinkedListNode incoming = new LinkedListNode(n, top, null);
        top = incoming;
    }
    
    public int pop(){
        if(top==null){
            throw new EmptyStackException();
        }
        LinkedListNode current = top;
        top=top.next;
        return current.data;
    }
    
    public int peek(){
        if(top==null){
            throw new EmptyStackException();
        }
        return top.data;
    }
    
    public void print() {
        StringBuilder sb = new StringBuilder();
        LinkedListNode current = top;
        while(current!=null){
            sb.append(current.data);
            if(current.next!=null){
                sb.append("->");
            }
            current=current.next;
        }
        System.out.println(sb.toString());
    }
}