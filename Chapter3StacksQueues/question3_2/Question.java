package question3_2;

public class Question {

    public static void main(String[] args) {
        Queue queue = new Queue();
        for(int i=0; i<10; i++){
            queue.enqueue(i);
        }
        queue.print();
        queue.dequeue();
        queue.print();
    }

}
