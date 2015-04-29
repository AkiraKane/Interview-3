/**
    5.3     Search in rotated sorted array
    Given a sorted array of n integers that has been rotated an unknown number of times, give an O(logn) algorithm that finds an element in the array. You may assume that the array was originally sorted in increasing order.
    Example
    Input: find 5 in {15,16,19,20,25,1,3,4,5,7,10,14}
    Output: 8 (the index of 5 in the array)
    (CareerCups150 -- 11.3)
    
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.
    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
    You are given a target value to search. If found in the array return its index, otherwise return -1.
    You may assume no duplicate exists in the array.
    (leetcode33)
    (leetcodecpp2.1.3)
    http://articles.leetcode.com/2010/04/searching-element-in-rotated-array.html
    
    Follow up for "Search in Rotated Sorted Array":
    What if duplicates are allowed?
    Would this affect the run-time complexity? How and why?
    Write a function to determine if a given target is in the array.
    (leetcode81)
    (leetcodecpp2.1.4)
 */
package question5_3;

public class Question {

    public static int search(int arr[], int left, int right, int target){
        if(left>right){
            return -1;
        }
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]<arr[right]){
                if(arr[mid]<target && target<=arr[right]){
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            } else if(arr[mid]>arr[right]){
                if(arr[left]<=target && target<arr[mid]){
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else if(arr[mid]==arr[right]){
                if(arr[mid]!=arr[left]){
                    right=mid-1;
                } else{
                    return -1;
                }
            }
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
        int[] a = {3,3,5,2,2,3};
        System.out.println(search(a, 0, 5, 5));
    }

}
