/**
    1.19    3SUM closest
    Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
    For example, given array S = {-1 2 1 -4}, and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    (leetcode16)
    (leetcodecpp2.1.9)
 */

package question1_19;

import java.util.Arrays;

public class Question {

    public static int threeSumClosest(int[] array, int sum) {        
        // sort the array
        Arrays.sort(array);
        int closestThreeSum = Integer.MAX_VALUE;
        for(int i=0; i< array.length-2; i++){
            int newClosestThreeSum = array[i] + twoSumClosest(array, i+1, sum-array[i]);
            if(newClosestThreeSum==sum){
                return newClosestThreeSum;
            } else {
                if(Math.abs(newClosestThreeSum-sum) < Math.abs(closestThreeSum-sum)){
                    closestThreeSum=newClosestThreeSum;
                }
            }
        }
        return closestThreeSum;
    }
    
    public static int twoSumClosest(int[] array, int left, int sum){
        int right = array.length-1;
        int closestSum = array[left]+array[right];
        while(left<right){
            int s = array[left]+array[right];
            if(s==sum){
                return sum;
            } else if(s<sum) {
                if(closestSum>sum){
                   return (Math.abs(s-sum)<=Math.abs(closestSum-sum)) ? s : closestSum;
                } else {
                    closestSum = s;
                }
                left++;
            } else {
                if(closestSum<sum){
                    return (Math.abs(s-sum)<=Math.abs(closestSum-sum)) ? s : closestSum;
                } else {
                    closestSum = s;
                }
                right--;
            }
        }
        return closestSum;
    }
    
    public static void main(String[] args) {
        int[] S = {-1, 0, 1, 2, -1, -4};
        System.out.println("closest three sum is: " + threeSumClosest(S, 1));
    }
}
