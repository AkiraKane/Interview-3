/**
    1.18    3SUM
    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
    Note:
    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},      
    A solution set is:     (-1, 0, 1)   (-1, -1, 2)
    Note that (0, 1, -1) is not part of the solution above, because (0, 1, -1) is the duplicate of (-1, 0, 1). Same with (-1, -1, 2).
    For a set S, there is probably no “the” solution, another solution could be:
    (0, 1, -1)
    (2, -1, -1)
    (leetcode15)
    (leetcodecpp2.1.8)
    http://www.leetcode.com/2010/04/finding-all-unique-triplets-that-sums.html
 */

package question1_18;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {

    public static ArrayList<ArrayList<Integer>> threeSum(int[] array, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        // sort the array
        Arrays.sort(array);
        
        for(int i=0; i< array.length-2; i++){
            ArrayList<ArrayList<Integer>> twoSumPair = twoSum(array, i+1, sum-array[i]);
            if(twoSumPair.size()!=0){
                for(ArrayList<Integer> pair : twoSumPair){
                    ArrayList<Integer> threeSumPair = new ArrayList<Integer>();
                    threeSumPair.add(array[1]);
                    threeSumPair.addAll(pair);
                    result.add(threeSumPair);
                }
            }
        }
        return result;
    }
    
    public static ArrayList<ArrayList<Integer>> twoSum(int[] array, int left, int sum){
        if(left>=array.length-1)
            return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int right = array.length-1;
        while(left<right){
            int s = array[left]+array[right];
            if(s==sum){
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(left);
                pair.add(right);
                result.add(pair);
                left--;
                right++;
            } else if(s<sum) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] S = {-1, 0, 1, 2, -1, -4};
        ArrayList<ArrayList<Integer>> result = threeSum(S, 0);
        
        // print out the result
        if(result!=null){
            for(ArrayList<Integer> pair : result){
                String entry = "(";
                for(Integer element : pair){
                    entry = entry + element + " ";
                }
                entry += ")";
            }
        }
    }
}
