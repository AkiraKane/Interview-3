/**
    1.8      Rotate Array
    Rotate an array of n elements to the right by k steps.
    For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
    Note:
    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Hint:
    Could you do it in-place with O(1) extra space?
    (leetcode189)
    http://www.leetcode.com/2010/04/rotating-array-in-place.html
 */

package question1_8;

public class Question {

    
    public static void reverse(int[] arr, int left, int right){
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
    public static void rotate(int[] arr, int n, int k){
        reverse(arr, 0, n-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr, 7, 3);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+",");
        }
    }

}
