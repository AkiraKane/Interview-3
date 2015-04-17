/**
1.35     Sliding Windows
A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. Following is an example:
The array is [1 3 -1 -3 5 3 6 7], and w is 3.


Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]
http://www.leetcode.com/2011/01/sliding-window-maximum.html
 */

package question1_35;

import java.util.Deque;
import java.util.LinkedList;

public class Question {

    public static int[] slidingWindows(int[] A, int w){
        int[] B = new int[A.length-w+1];
        
        // double-ended queue
        Deque<Integer> deque = new LinkedList<Integer>();
        for(int i=0; i<w; i++){
            while(!deque.isEmpty() && A[i]>=A[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        
        for(int i=w; i<A.length; i++){
            B[i-w] = A[deque.getFirst()];
            while(!deque.isEmpty() && A[i]>=A[deque.getLast()]){
                deque.removeLast();
            }
//            while(!deque.isEmpty() && deque.getFirst()<=(i-w)){
//                deque.removeFirst();
//            }
            if(!deque.isEmpty() && deque.getFirst()<=(i-w)){
                deque.removeFirst();
            }
            
            deque.addLast(i);
        }
        B[A.length-w] = A[deque.getFirst()];
        
        return B;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] A = {1,3,-1,-3,5,3,6,7};
        int[] B = slidingWindows(A, 3);
        for(int ele : B){
            System.out.println(ele);
        }
    }
}
