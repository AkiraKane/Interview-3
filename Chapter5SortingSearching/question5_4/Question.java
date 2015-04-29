/**
    5.4     A magic index in an array A[0...n-1] is defined to be an index such that A[i] = i. 
    Given a sorted array, write a method to find a magic index, if one exists, in array A.
    FOLLOW UP
    What if the values are not distinct?
    (CareerCups150 -- 9.3)
 */
package question5_4;

public class Question {

    // Slow version of search
    public static int searchSlow(int[] array){
        for(int i=0; i<array.length;i++){
            if(array[i]==i){
                return i;
            }
        }
        return -1;
    }
    
    public static int searchFast(int[] array, int start, int end){
        if (end < start || start < 0 || end >= array.length) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midValue == midIndex) {
            return midIndex;
        }
        /* Search left */
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = searchFast(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }
        
        /* Search right */
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = searchFast(array, rightIndex, end);
        
        return right;
    }
    
    
    public static void main(String[] args) {
        
        
        
    }

}
