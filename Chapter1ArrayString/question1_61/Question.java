/**
    1.61    Gas Station
    There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
    Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
    Note:
    The solution is guaranteed to be unique.
    (leetcode134)
    (leetcode2.1.21)
    http://blog.csdn.net/youwuwei2012/article/details/31394399
 */

package question1_61;

public class Question {
    
    public static int canCompleteCircuit(int[] gas, int[] cost){
        int total = 0;
        int j=-1;
        for(int i=0,sum=0; i<gas.length; i++){
            sum+=(gas[i]-cost[i]);
            total+=(gas[i]-cost[i]);
            if(sum<0){
                j=i;
                sum=0;
            }
        }
        return total>=0?(j+1):-1;
    }
    
    
    public static void main(String[] args) {

    }

}
