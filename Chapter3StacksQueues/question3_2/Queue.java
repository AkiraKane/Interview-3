package question3_2;

import CtCILibrary.LinkedListNode;

public class Queue {
    LinkedListNode head;
    LinkedListNode tail;

    public Queue() {
        head=null;
        tail=null;
    }
    
    public void enqueue(int n){
        LinkedListNode newNode = new LinkedListNode(n, null, tail);
        if(tail==null){
            head=tail=newNode;
        }
        tail.next=newNode;
        tail=newNode;
    }
    
    public int dequeue(){
        if(head==null){
            throw new IllegalStateException();
        }
        int result = head.data;
        if(head==tail){
            head=tail=null;
        }
        head=head.next;
        return result;
    }
    
    public void print() {
        StringBuilder sb = new StringBuilder();
        LinkedListNode runner = head;
        while(runner!=null){
            sb.append(runner.data);
            if(runner.next!=null){
                sb.append("->");
            }
            runner=runner.next;
        }
        System.out.println(sb.toString());
    }
}
