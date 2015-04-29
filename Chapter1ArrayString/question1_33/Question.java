/**
    1.33    Given an Array A and an integer K, find if there exist a contiguous sub-array of A whose sum = K
    e.g [1,24,4,7,9,45] and K=16
    subarray =[7,9]
    O(n^2)
 */

package question1_33;

public class Question {

    public static boolean subArraySumK(int[] array, int k){
        for(int i=0; i<array.length; i++){
            for(int j=i; i<array.length; j++){
                int sum = 0;
                sum+=array[j];
                if(sum==k){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        
    }

}
