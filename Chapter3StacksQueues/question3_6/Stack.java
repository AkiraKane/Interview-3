package question3_6;

public class Stack {
    private final int capacity;
    public Node top;
    public Node bottom;
    public int size=0;

    public Stack(int capacity){
        this.capacity = capacity;
    }

    public boolean isFull(){
        return this.capacity==this.size;
    }

    public boolean push(int v){
        if(size>=capacity){
            return false;
        }
        Node node = new Node(v);
        size++;
        if(size==1){
            bottom=node;
            top = node;
        } else {
            node.below=top;
            top.above = node;
            top = node;
        }
        return true;
    }

    public int pop(){
        if(top==null){
            return -1;
        }
        Node t = top;
        top = top.below;
        size--;
        return t.value;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int removeBottom() {
        Node b = bottom;
        bottom=bottom.above;
        if(bottom!=null) {
            bottom.below = null;
        }
        size--;
        return b.value;
    }
}
