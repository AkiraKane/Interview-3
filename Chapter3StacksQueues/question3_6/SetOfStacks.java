package question3_6;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks {
    List<Stack> stacks = new ArrayList<Stack>();
    public int capacity;

    public SetOfStacks(int capacity){
        this.capacity = capacity;
    }

    public void push(int v){
        Stack last = getLastStack();
        if(last!=null && !last.isFull()) {
            last.push(v);
        } else {
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    public int pop() {
        Stack last = getLastStack();
        int v = last.pop();
        if(last.size==0){
            stacks.remove(stacks.size()-1);
        }
        return v;
    }

    public int popAt(int index){
        return leftShift(index, true);
    }

    public boolean isEmpty(){
        Stack last = getLastStack();
        return last==null || last.isEmpty();
    }

    private Stack getLastStack(){
        if(stacks.size()==0){
            return null;
        }
        return stacks.get(stacks.size()-1);
    }

    private int leftShift(int index, boolean removeTop){
        Stack stack = stacks.get(index);
        int removedItem;
        if(removeTop){
            removedItem = stack.pop();
        } else {
            removedItem = stack.removeBottom();
        }
        if(stack.isEmpty()){
            stacks.remove(index);
        } else if(stacks.size()>index+1){
            int v = leftShift(index+1, false);
            stack.push(v);
        }
        return removedItem;
    }
}
