/**
    1.20    4SUM
    Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
    Note:
    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
    The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.      
    A solution set is:  (-1,  0, 0, 1)     (-2, -1, 1, 2)   (-2,  0, 0, 2) 
    (leetcode18)
    (leetcodecpp2.1.10)
 */
package question1_20;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {
    
    public static ArrayList<ArrayList<Integer>> fourSum(int[] array, int sum){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        // cache: two sum 
        // key: two sum
        // value: all possible pairs of index, sum is the key, value is the array list of pairs of index
        HashMap<Integer, ArrayList<ArrayList<Integer>>> cache = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++) {
                int twoSum  = array[i]+array[j];
                ArrayList<Integer> newPair = new ArrayList<Integer>();
                newPair.add(i);
                newPair.add(j);
                ArrayList<ArrayList<Integer>> entryInCache;
                if(cache.containsKey(twoSum)){
                    entryInCache = cache.get(twoSum);
                    entryInCache.add(newPair);
                } else {
                    entryInCache = new ArrayList<ArrayList<Integer>>();
                    entryInCache.add(newPair);
                    cache.put(twoSum, entryInCache);
                }
            }
        }
        
        // for loop hashmap's keyset, which is the twosum 
        // try to find another twosum pair, which value is target-twosum
        for(Integer firstTwoSum : cache.keySet()){
            int secondTwoSum = sum-firstTwoSum;
            if(cache.containsKey(secondTwoSum)){
                ArrayList<ArrayList<Integer>> firstTwoSumPairList = cache.get(firstTwoSum);
                for(ArrayList<Integer> firstTwoSumPair : firstTwoSumPairList){
                    int firstTwoSumPairIndex1 = firstTwoSumPair.get(0);
                    int firstTwoSumPairIndex2 = firstTwoSumPair.get(1);
                    ArrayList<ArrayList<Integer>> secondTwoSumPairList = cache.get(secondTwoSum);
                    for(ArrayList<Integer> secondTwoSumPair : secondTwoSumPairList){
                        int secondTwoSumPairIndex1 = secondTwoSumPair.get(0);
                        int secondTwoSumPairIndex2 = secondTwoSumPair.get(1);
                        if(firstTwoSumPairIndex1!=secondTwoSumPairIndex1 && firstTwoSumPairIndex1!=secondTwoSumPairIndex2 && firstTwoSumPairIndex2!=secondTwoSumPairIndex1 && firstTwoSumPairIndex2!=secondTwoSumPairIndex2){
                            ArrayList<Integer> fourSumPair = new ArrayList<Integer>();
                            fourSumPair.add(firstTwoSumPairIndex1);
                            fourSumPair.add(firstTwoSumPairIndex2);
                            fourSumPair.add(secondTwoSumPairIndex1);
                            fourSumPair.add(secondTwoSumPairIndex2);
                            result.add(fourSumPair);
                        }
                    }
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] S = {1, 0, -1, 0, -2, 2};
        ArrayList<ArrayList<Integer>> result = fourSum(S, 0);
        for(ArrayList<Integer> entry : result){
            String pair = "";
            for(Integer index : entry){
                pair += index + " ";
            }
            System.out.println(pair);
        }
    }
}
