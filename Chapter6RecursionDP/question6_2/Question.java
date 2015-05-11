/**
    6.2     Combinations
    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
    For example,
    If n = 4 and k = 2, a solution is:
    [  [2,4],   [3,4],   [2,3],   [1,2],   [1,3],   [1,4], ]
    (leetcode77)
    (leetcodecpp8.5)
 */
package question6_2;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public static List<List<Integer>> combinations(int n, int k){
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
        combination(n, k, new ArrayList<Integer>(), pairs);
        return pairs;
    }
    
    public static void combination(int n, int k, List<Integer> pair, List<List<Integer>> pairs){
        if(pair.size()==k){
            pairs.add(pair);
            return;
        }
        int start = pair.isEmpty() ? 0 : pair.get(pair.size()-1);
        for(int i=start+1; i<=n; i++){
            List<Integer> newPair = new ArrayList<Integer>();
            newPair.addAll(pair);
            newPair.add(i);
            combination(n, k, newPair, pairs);
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> result = combinations(4, 2);
        for(List<Integer> pair : result){
            for(Integer ele : pair){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
