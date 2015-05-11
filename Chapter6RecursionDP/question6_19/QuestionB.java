/**
    Combination sum II
    Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
    Each number in C may only be used once in the combination.
    Note:
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.
    For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
    A solution set is: 
    [1, 7] 
    [1, 2, 5] 
    [2, 6] 
    [1, 1, 6] 
    (leetcode40)
    (leetcodecpp10.8)
 */

package question6_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionB {

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combination(candidates, target, 0, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public static void combination(int[] candidates, int target, int position, int sum, List<Integer> pair, List<List<Integer>> result){
        if(position>=candidates.length){
            return;
        }

        if(position==0 || (position>0 && candidates[position]!=candidates[position-1]) || (position>0 && candidates[position]==candidates[position-1] && !pair.contains(candidates[position]))){
            // don't include current candidate
            List<Integer> newPair1 = new ArrayList<Integer>();
            newPair1.addAll(pair);
            combination(candidates, target, position+1, sum, newPair1, result);
        }
        
        // include the current candidate
        int newSum = sum+candidates[position]; 
        if(newSum<=target){
            List<Integer> newPair2 = new ArrayList<Integer>();
            newPair2.addAll(pair);
            newPair2.add(candidates[position]);
            if(newSum==target){
                result.add(newPair2);
                return;
            } else {
                combination(candidates, target, position+1, newSum, newPair2, result);
            }
        }
    }
    
    
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> result = combinationSum(candidates, target);
        
        for(List<Integer> pair : result){
            for(Integer element : pair){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
}
