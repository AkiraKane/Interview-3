/**
    1.3 Remove Element
    Given an array and a value, remove all instances of that value in place and return the new length. The order of elements can be changed. It doesn't matter what you leave beyond the new length.
    (leetcode27)
    (leetcode2.1.11)
 */
package question1_3;

public class Question {

    public static int removeElement(int[] A, int target){
        int left = 0;
        int right = A.length-1;
        while(left<right){
            // left: find the first target
            while(A[left]!=target){
                left++;
            }
            
            // right: find the first non-target
            while(A[right]==target){
                right--;
            }
            
            // swap left and right
            if(left<right){
                int temp = A[left];
                A[left]=A[right];
                A[right]=temp;
            }
        }
        
        for(int i=0; i<=right;i++){
            System.out.print(A[i]+" ");
        }
        return (right+1);
    }
    
    
    public static void main(String[] args) {
        int[] A = {1,2,2,2,3,4};
        removeElement(A, 2);
    }

}
