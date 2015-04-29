package question3_3;

public class MyArrayStacks {

    // this is a simple solution
    // reserve the space for individual stack in the buffer
    // stack0 from index 0 to stackSize-1
    // stack1 from stackSize to 2*stackSize-1
    // stack2 from 2*stackSize to 3*stackSize-1
    // .....
    private int size = 10;
    private int[] buffer = new int[size*3];
    private int[] stackPointer = {-1, -1, -1};
    
    public MyArrayStacks(){
        
    }
    
    public void push(int stackNum, int value) {
        if(stackPointer[stackNum]+1 >= size){
            // throw exception
        }
        stackPointer[stackNum]++;
        buffer[absTopOfStack(stackNum)] = value;
    }
    
    public int pop(int stackNum) {
        if(isEmpty(stackNum)){
            
        }
        int value = buffer[absTopOfStack(stackNum)];
        buffer[absTopOfStack(stackNum)]=0;
        stackPointer[stackNum]--;
        return value;
    }
    
    public int peek(int stackNum){
        if(isEmpty(stackNum)){
            
        }
        return buffer[absTopOfStack(stackNum)];
    }
    
    public boolean isEmpty(int stackNum){
        return stackPointer[stackNum]==-1;
    }
    
    private int absTopOfStack(int stackNum) {
        return stackNum*size+stackPointer[stackNum];
    }

}
