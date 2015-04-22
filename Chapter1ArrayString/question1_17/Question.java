/**
    1.17    2SUM
    Given an array of integers, find two numbers such that they add up to a specific target number. 
    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
    Please note that your returned answers (both index1 and index2) are not zero-based. 
    You may assume that each input would have exactly one solution.
    (CleanCodeHandbook--1)
    (leetcode1)
    (leetcode2.1.7)
 */

package question1_17;

import java.util.HashMap;

public class Question {

    // unsorted array
    public static int[] twoSum(int[] numbers, int target){
        // <number, index in array>
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++){
            int x = numbers[i];
            if(map.containsKey(target-x)){
                return new int[] {map.get(target-x), i};
            }
            map.put(x, i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] test = {9, 3, 6, 5, 7, -1, 13, 14, -2, 12, 0};
        int[] result = twoSum(test, 11);
        if(result!=null){
            System.out.println(result[0] + "," + result[1]);
        }
    }
    
}
