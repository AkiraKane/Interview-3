/**
    1.31    Maximum Subarray
    You are given an array of integers (both positive and negative). Find the continuous sequence with the largest sum, Return the sum.
    Example
    Input: 2, -8, 3, -2, 4, -10
    Output: 5 (i.e., {3,-2,4})
    (CareerCups150 -- 17.8)
     
    Find the contiguous subarray within an array (containing at least one number) that has the largest sum. For example, given the array [2, 1, –3, 4, –1, 2, 1, –5, 4], The contiguous array [4, –1, 2, 1] has the largest sum = 6.
    More practice:
    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
    (CleanCodeHandbook--45)
    (leetcode53)
    (leetcodecpp13.2)
 */

package question1_31;

public class Question {

    public static int largestSum(int[] array){
        int largestSum=0;
        int sum=0;
        for(int i=0; i<array.length; i++){
            sum+=array[i];
            if(sum<0){
                sum=0;
            } else{
                if(sum>largestSum){
                    largestSum=sum;
                }
            }
        }
        return largestSum;
    }
    
    
    public static int largestSum1(int[] array){
        
        
        
        return 0;
    }
    
    public static void main(String[] args) {
        int[] array = {2,-8,3,-2,4,-10};
        System.out.println(largestSum(array));
        
        
    }

}
