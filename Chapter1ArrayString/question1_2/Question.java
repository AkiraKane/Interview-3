/**
    1.2     Remove duplicates from sorted array
    Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
    Do not allocate extra space for another array, you must do this in place with constant memory.
    For example,
    Given input array A = [1,1,2],
    Your function should return length = 2, and A is now [1,2].
    (leetcode26)
    (leetcodecpp2.1.1)
     
    Follow up for "Remove Duplicates":
    What if duplicates are allowed at most twice?
    For example,
    Given sorted array A = [1,1,1,2,2,3],
    Your function should return length = 5, and A is now [1,1,2,2,3].
    (leetcode80)
    (leetcodecpp2.1.2)
 */

package question1_2;

public class Question {

    public static int removeDuplicates(int[] A) {
        int index = 0;
        int runner = 0;
        while(runner<A.length){
            int currentNum =A[runner];
            while(runner<A.length && A[runner]==currentNum){
                runner++;
            }
            A[index++]=currentNum;
        }
        
        for(int i=0; i<index;i++){
            System.out.print(A[i] + " ");
        }
        
        return (index+1);
    }
    
    public static int removeDuplicatesAtMostTwice(int[] A){
        int index = 0;
        int runner = 0;
        while(runner<A.length){
            int currentNum = A[runner];
            int count = 0;
            while(runner<A.length && A[runner]==currentNum){
                runner++;
                count++;
            }
            if(count==1){
                A[index++]=currentNum;
            } else if(count>=2){
                A[index++]=currentNum;
                A[index++] = currentNum;
            }
        }
        
        
        for(int i=0; i<index;i++){
            System.out.print(A[i] + " ");
        }
        return (index+1);
    }
    
    
    public static void main(String[] args) {
        int[] A = {1,2,2,2,4,4,5,5,5};
        removeDuplicatesAtMostTwice(A);
    }
    
}
