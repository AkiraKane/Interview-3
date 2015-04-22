/**
    6.1     Subsets
    Get all subsets of a set.
    (CareerCups150 -- 9.4)
    
    Given a set of distinct integers, S, return all possible subsets.
    Note:
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    For example,
    If S = [1,2,3], a solution is:
    [   [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
    (leetcode78)
    (leetcodecpp8.1)
     
    SubsetsII
    Given a collection of integers that might contain duplicates, S, return all possible subsets.
    Note:
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    For example,
    If S = [1,2,2], a solution is:
    [   [2],   [1],   [1,2,2],   [2,2],   [1,2],   [] ]
    (leetcode90)
    (leetcodecpp8.2)
 */

package question6_1;

import java.util.ArrayList;

public class Question {
    
    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> allSubsets;
        //
        if(index<0){
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<Integer>());
        } else {
            allSubsets = getSubsets(set, index-1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubnets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subnet : allSubsets) {
                ArrayList<Integer> newsubnet = new ArrayList<Integer>();
                newsubnet.addAll(subnet);
                newsubnet.add(item);
                moresubnets.add(newsubnet);
            }
            allSubsets.addAll(moresubnets);
        }
        return allSubsets;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> subsets = getSubsets(list, list.size()-1);
        System.out.println(subsets.toString());
    }

}
