/**
    6.24    Jump Game
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Your goal is to reach the last index in the minimum number of jumps.
    For example:
    Given array A = [2,3,1,1,4]
    The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
    (leetcode45)
    (leetcodecpp12.2)
 */

package question6_24;

public class Question {


    public static int minJumps(int[] A){
        int[] minJumps =  new int[A.length];
        minJumps[A.length-1] = 0;
        for(int i=A.length-2; i>=0; i--){
            if((A[i]+i)>=(A.length-1)){
                minJumps[i]=1;
            } else {
                int min = Integer.MAX_VALUE;
                for(int j=1; j<=A[i]; j++){
                    if(minJumps[i+j]<min){
                        min=minJumps[i+j];
                    }
                }
                minJumps[i] = 1+min;
            }
        }
        return minJumps[0];
    }

    public static void main(String[] args) {
        int[] A = {2,3,1,1,4};
        System.out.println(minJumps(A));
    }

}
