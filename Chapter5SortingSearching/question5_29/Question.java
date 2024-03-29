/**
    5.29    Sort a nearly sorted array
    Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time. 
    For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
    http://www.geeksforgeeks.org/nearly-sorted-algorithm/
 */
package question5_29;

import java.util.PriorityQueue;

public class Question {
    
    public static void sort(int[] array, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i=0;i<=k;i++){
            minHeap.add(array[i]);
        }
        for(int i=0; i<array.length; i++){
            array[i] = minHeap.poll();
            if((i+k+1)<array.length){
                minHeap.add(array[i+k+1]);
            }
        }
    }
    
    public static void main(String[] args) {

    }

}
