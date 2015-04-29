/**
    5.12    Find Minimum in sorted rotated array
    Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
    Find the minimum element.
    You may assume no duplicate exists in the array.
    (CleanCodeHandbook--49)
    (leetcodecpp153)
    
    If the rotated sorted array could contain duplicates? Is your algorithm still O(log n) in runtime complexity?
    (CleanCodeHandbook--50)
    (leetcodecpp154)
 */
package question5_12;

public class Question {

    public static int findMin(int[] A){
        int left=0, right = A.length-1;
        if(A[left]<=A[right]){
            return left;
        } else if(A[right]<=A[right-1]){
            return right;
        }
        
        while(left<=right){
            int mid = (left+right)/2;
            if(mid>0 && mid<A.length-1 && A[mid]<=A[mid-1] && A[mid]<=A[mid+1]){
                return mid;
            }
            if(A[mid]>A[right]){
                left=mid+1;
            } else if(A[mid]<=A[right]){
                right=mid-1;
            }
        }
        return -1;  //???
    }
    
    public static void main(String[] args) {
        int[] A = {5,6,0,1,2,3,4};
        System.out.println(findMin(A));
    }

}
