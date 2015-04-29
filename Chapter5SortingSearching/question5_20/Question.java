/**
    5.20    Merge Sorted Array  
    You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B Write a method to merge B into A in sorted order
    (CareerCups150 -- 11.1)
    
    Given two sorted integer arrays A and B, merge B into A as one sorted array.
    Note:
    You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
    (leetcode88)
    (leetcodecpp6.1)
 */

package question5_20;

import CtCILibrary.AssortedMethods;

public class Question {
    
    public static void merge(int[] a, int[] b, int lastA, int lastB){
        int indexMerged = lastB + lastA -1;
        int indexA = lastA - 1;
        int indexB = lastB -1;
        
        while(indexA>=0 && indexB>=0){
            if(a[indexA]>b[indexB]){
                a[indexMerged]=a[indexA];
                indexA--;
            } else {
                a[indexMerged]=b[indexB];
                indexB--;
            }
            indexMerged--;
        }
        while(indexB>=0){
            a[indexMerged--]=b[indexB--];
        }
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 7, 6, 7, 7};
        merge(a, b, 8, 6);
        System.out.println(AssortedMethods.arrayToString(a));
    }

}
