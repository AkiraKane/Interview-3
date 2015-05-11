/**
    6.19    Combination sum
    Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
    The same repeated number may be chosen from C unlimited number of times.
    Note:
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.
    For example, given candidate set 2,3,6,7 and target 7, 
    A solution set is: 
    [7] 
    [2, 2, 3] 
    (leetcode39)
    (leetcodecpp10.7)
    http://articles.leetcode.com/2010/09/print-all-combinations-of-number-as-sum.html
    
 */

package question6_19;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public static void combination(int[] candidates, int target, int position, int sum, List<Integer> pair, List<List<Integer>> result){
        if(position>=candidates.length){
            return;
        }
        for(int i=0; i<=(target-sum)/candidates[position]; i++){
            List<Integer> newPair = new ArrayList<Integer>();
            newPair.addAll(pair);
            int newSum = sum;
            for(int j=0; j<i; j++){
                newPair.add(candidates[position]);
                newSum+=candidates[position];
            }
            if(newSum==target){
                result.add(newPair);
            } else {
                combination(candidates, target, position+1, newSum, newPair, result);
            }
        }
    }
    
    
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combination(candidates, target, 0, 0, new ArrayList<Integer>(), result);
        
        for(List<Integer> pair : result){
            for(Integer element : pair){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }

}
