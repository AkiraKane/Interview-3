/**
5.1     Binary Search
    Implementation of Binary Search   O(logn)
    It can reduce time complexity of searching from O(n) to O(logn). 
    When programming, please pay attention to every extreme condition and boundary checking.
    Example:
    a)  It’s used in “Finding Longest Increasing Subsequence”, reducing time complexity from O(n^2) to O(nlogn)
    b) Array should be 0,1,2,...., N continually, but there is only one element missed in this array, please find it out.
*/

package question5_1;

public class Question {
    
    public int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while(left<=right){
            mid = (left+right)/2;
            if(arr[mid]<target){
                left=mid+1;
            } else if(arr[mid]>target){
                right=mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
