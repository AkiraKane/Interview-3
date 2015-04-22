/**
    1.45    There is an array A[N] of N numbers. You have to compose an array Output[N] such that Output[i] will be equal to multiplication of all the elements of A[N] except A[i]. Solve it without division operator and in O(n).
    For example Output[0] will be multiplication of A[1] to A[N-1] and Output[1] will be multiplication of A[0] and from A[2] to A[N-1].
    Example:
    A: {4, 3, 2, 1, 2}
    OUTPUT: {12, 16, 24, 48, 24}
    http://www.leetcode.com/2010/04/multiplication-of-numbers.html  
 */
package question1_45;

public class Question {

    public static int[] multiply(int[] array){
        int[] result = new int[array.length];
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        
        left[0] = array[0];
        for(int i=1;i<array.length; i++){
           left[i] = left[i-1]*array[i];
        }
        right[array.length-1] = array[array.length-1];
        for(int i=array.length-2; i>=0; i--){
            right[i]=right[i+1]*array[i];
        }
        
        result[0] = right[1];
        result[array.length-1] = left[array.length-2]; 
        for(int i=1; i<=array.length-2; i++){
            result[i] = left[i-1]*right[i+1];
        }
        
        return result;
    }
    
    
    public static void main(String[] args) {
        int[] array = {4, 3, 2, 1, 2};
        int[] result = multiply(array);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
}
