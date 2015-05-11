package question3_7;

import java.util.Stack;

public class Tower {

    private final Stack<Integer> disks;
    private final int index;

    public Tower(int i){
        disks = new Stack<Integer>();
        index = i;
    }

    public int index() {
        return index;
    }

    public void add(int d){
        if(!disks.isEmpty() && disks.peek()<=d){
            System.out.println("error");
        } else {
            disks.push(d);
        }
    }

    private void moveTopTo(Tower t){
        int top = disks.pop();
        t.add(top);
    }

    public void print() {
        System.out.println("Contents of Tower " + index() + ": " + disks.toString());
    }

    public void moveDisks(int n, Tower destination, Tower buffer){
        if(n==1){
            moveTopTo(destination);
            return;
        }
        moveDisks(n-1,  buffer, destination);
        moveTopTo(destination);
        buffer.moveDisks(n-1, destination, this);
    }
}
