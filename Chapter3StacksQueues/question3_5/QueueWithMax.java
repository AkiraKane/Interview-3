package question3_5;

import java.util.LinkedList;

public class QueueWithMax extends LinkedList<Integer> {

    private LinkedList<Integer> queueMax;
    
    public QueueWithMax(){
        queueMax = new LinkedList<Integer>();
    }
    
    public Integer removeFirst(){
        Integer first = super.removeFirst();
        
        if(queueMax.getFirst()==first){
            queueMax.removeFirst();
        }
        
        return first;
    }
    
    public Integer getFirst(){
        return super.getFirst();
    }
    
    public void addLast(int value){
        super.addLast(value);
        // max queue
        // from tail, remove all nums which are smaller than this value
        // put this value to the tail
        while(queueMax.getLast()<value){
            queueMax.removeLast();
        }
        queueMax.addLast(value);
    }
    
    public int getMax(){
        return queueMax.getFirst();
    }

}
