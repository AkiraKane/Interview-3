package CtCILibrary;

public class SingleLinkedListNode {
    public SingleLinkedListNode next;
    public SingleLinkedListNode prev;
    public SingleLinkedListNode last;
    public int data;
    public SingleLinkedListNode(int d, SingleLinkedListNode n, SingleLinkedListNode p) {
        data = d;
        setNext(n);
        setPrevious(p);
    }
    
    public SingleLinkedListNode() { }

    public void setNext(SingleLinkedListNode n) {
        next = n;
        if (this == last) {
            last = n;
        }
        if (n != null && n.prev != this) {
            n.setPrevious(this);
        }
    }
    
    public void setPrevious(SingleLinkedListNode p) {
        prev = p;
        if (p != null && p.next != this) {
            p.setNext(this);
        }
    }   
    
    public String printForward() {
        if (next != null) {
            return data + "->" + next.printForward();
        } else {
            return ((Integer) data).toString();
        }
    }
    
    public SingleLinkedListNode clone() {
        SingleLinkedListNode next2 = null;
        if (next != null) {
            next2 = next.clone();
        }
        SingleLinkedListNode head2 = new SingleLinkedListNode(data, next2, null);
        return head2;
    }
}
