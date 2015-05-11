/**
    1.39    Insert Interval
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    You may assume that the intervals were initially sorted according to their start times.
    Example 1:
    Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
    Example 2:
    Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
    This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
    (leetcode57)
    (leetcodecpp15.3)
 */

package question1_39;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public static List<int[]> insertInterval(List<int[]> intervals, int[] newInterval){
        List<int[]> result = new ArrayList<int[]>();
        int leftBound = 0;
        int rightBound = 0;

        int i;
        for(i=0; i<intervals.size(); i++){
            int[] interval = intervals.get(i);
            if(interval[1]<newInterval[0]){
                // no merge
                result.add(interval);
            } else {
                leftBound = Math.min(interval[0], newInterval[0]);
                break;
            }
        }
        if(i==intervals.size()){
            result.add(newInterval);
        } else {
            int j;
            for(j=i; j<intervals.size(); j++){
                int[] interval = intervals.get(j);
                if(interval[0]>newInterval[1]){
                    rightBound=Math.max(intervals.get(j-1)[1], newInterval[1]);
                    break;
                }
            }

            if(j<intervals.size()){
                result.add(new int[]{leftBound, rightBound});
                for(int k=j; k<intervals.size(); k++){
                    result.add(intervals.get(k));
                }
            } else {
                rightBound =Math.max(intervals.get(intervals.size()-1)[1], newInterval[1]);
                result.add(new int[]{leftBound, rightBound});
            }
        }
        return result;
    }



    public static void main(String[] args) {
        List<int[]> intervals = new ArrayList<int[]>();
        intervals.add(new int[]{1,2});
        intervals.add(new int[]{3,5});
        intervals.add(new int[]{6,7});
        intervals.add(new int[]{8,10});
        intervals.add(new int[]{12,16});

        int[] newInterval = new int[]{4,9};
        List<int[]> result = insertInterval(intervals, newInterval);

        for(int[] pair : result){
            System.out.println(pair[0]+","+pair[1]);
        }
    }
}
