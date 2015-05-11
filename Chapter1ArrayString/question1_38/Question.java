/**
    1.38    Merge Intervals
    Given a collection of intervals, merge all overlapping intervals.
    For example,
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18].
    (leetcode56)
    (leetcodecpp15.4)
 */

package question1_38;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public static List<int[]> mergeIntervals(List<int[]> intervals){
        List<int[]> result = new ArrayList<int[]>();
        int[] currentInterval = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            int[] interval = intervals.get(i);
            if(currentInterval[1]<interval[0]){
                result.add(currentInterval);
                currentInterval = interval;
            } else {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            }
        }
        result.add(currentInterval);
        return result;
    }

    public static void main(String[] args) {
        List<int[]> intervals = new ArrayList<int[]>();
        intervals.add(new int[]{1,3});
        intervals.add(new int[]{2,6});
        intervals.add(new int[]{8,10});
        intervals.add(new int[]{15,18});

        List<int[]> result = mergeIntervals(intervals);
        for(int[] interval : result){
            System.out.println("["+interval[0]+","+interval[1]+"]");
        }
    }
}
