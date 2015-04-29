/**
    1.34    Given two arrays of integer, check the second array is the subarray of the first array.
    EXAMPLE:
    Input: [1,3,5], [1,3]
    Output:  true
    Input: [1,3,5], [1,1,3]
    Output: false
 */
package question1_34;

public class Question {

    public static boolean isSubArray(int[] A, int[] B){
        if(A.length<B.length){
            return false;
        }
        for(int i=0; i<=A.length-B.length; i++){
            for(int j=0; j<B.length; j++){
                if(A[i+j]!=B[j]){
                    break;
                }
                if(j==B.length-1){
                    return true;
                }
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[] A = {1,3,5};
        int[] B = {1,3};
        System.out.println(isSubArray(A, B));
        
    }

}
