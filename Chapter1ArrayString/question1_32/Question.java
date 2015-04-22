/**
    1.32    Maximum Product Subarray
    Find the contiguous subarray within an array of integers that has the largest product. For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
    (CleanCodeHandbook--46)
    (leetcode152)
    http://www.geeksforgeeks.org/maximum-product-subarray/
 */
package question1_32;

public class Question {

    public static int max(int a, int b){
        return (a>=b) ? a : b;
    }
    
    public static int min(int a, int b) {
        return (a<b) ? a : b;
    }

    public static int largestProduct(int[] array){
        int largestProduct = array[0];
        int[] maxProduct = new int[array.length];
        int[] minProduct = new int[array.length];
        maxProduct[0] = array[0];
        minProduct[0] = array[0];
        for(int i=1; i<array.length; i++){
            if(array[i]>0){
                maxProduct[i] = max(array[i], maxProduct[i-1]*array[i]);
                minProduct[i] = min(array[i], minProduct[i-1]*array[i]);
                
            } else if(array[i]<0) {
                maxProduct[i] = max(array[i], minProduct[i-1]*array[i]);
                minProduct[i] = min(array[i], maxProduct[i-1]*array[i]);
            } else {
                maxProduct[i] = minProduct[i] = 0;
            }
            if(maxProduct[i]>maxProduct[i-1]){
                largestProduct=maxProduct[i];
            }
        }
        return largestProduct;
    }
    
    public static void main(String[] args) {
        int[] array = {2,3,-6,-2,-4};
        System.out.println(largestProduct(array));
    }
}

