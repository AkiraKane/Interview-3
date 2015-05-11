/**
    6.35    Triangle
    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
    For example, given the following triangle
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
    Note:
    Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

    (leetcode120)
    (leetcodecpp13.1)
 */

package question6_35;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public static int minPathSum(List<List<Integer>> triangle){

        List<List<Integer>> sum = new ArrayList<List<Integer>>();
        List<Integer> firstSumLine = new ArrayList<Integer>();
        firstSumLine.add(triangle.get(0).get(0));
        sum.add(firstSumLine);

        for(int i=1; i<triangle.size(); i++){
            List<Integer> line = triangle.get(i);
            List<Integer> lastSumLine = sum.get(i-1);
            List<Integer> newSumLine = new ArrayList<Integer>();
            for(int j=0; j<line.size(); j++){
                int val = line.get(j);
                int min;
                if(j==0){
                    min = val + lastSumLine.get(0);
                } else if(j==line.size()-1){
                    min = val + lastSumLine.get(lastSumLine.size()-1);
                } else {
                    min = val + Math.min(lastSumLine.get(j-1), lastSumLine.get(j));
                }
                newSumLine.add(min);
            }
            sum.add(newSumLine);
        }

        List<Integer> lastSumLine = sum.get(sum.size()-1);
        int minPath = Integer.MAX_VALUE;
        for(Integer val : lastSumLine){
            if(val<minPath){
                minPath = val;
            }
        }

        return minPath;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> line;
        line = new ArrayList<Integer>();
        line.add(2);
        triangle.add(line);
        line = new ArrayList<Integer>();
        line.add(3);
        line.add(4);
        triangle.add(line);
        line = new ArrayList<Integer>();
        line.add(6);
        line.add(5);
        line.add(7);
        triangle.add(line);
        line = new ArrayList<Integer>();
        line.add(4);
        line.add(1);
        line.add(8);
        line.add(3);
        triangle.add(line);
        System.out.println(minPathSum(triangle));
    }

}
