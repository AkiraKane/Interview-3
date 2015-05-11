/**
    5.28    Median of Two sorted arrays
    There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
    (leetcode4)
    (leetcodecpp2.1.5)
    http://articles.leetcode.com/2011/03/median-of-two-sorted-arrays.html
 */

package question5_28;

public class Question {

    public static int median(int[] A, int[] B){
        int target = (A.length+B.length)/2;
        int index=0;
        int indexA = 0;
        int indexB = 0;
        while(indexA<A.length && indexB<B.length){
            int val;
            if(A[indexA]<=B[indexB]){
                val = A[indexA++];
            } else {
                val = B[indexB++];
            }
            if(index==target){
                return val;
            }
            index++;
        }
        if(indexA<A.length){
            while(index<target){
                indexA++;
                index++;
            }
            return A[indexA];
        }
        while(index<target){
            indexB++;
            index++;
        }
        return B[indexB];
    }
    
    
    public static void main(String[] args) {

    }

}
