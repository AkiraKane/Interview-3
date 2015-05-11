/**
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Determine if you are able to reach the last index.
    For example:
    A = [2,3,1,1,4], return true.
    A = [3,2,1,0,4], return false.
    (leetcode55)
    (leetcodecpp12.1)
 */
package question6_24;

public class QuestionB {

    public static boolean checkJump(int[] A){
        boolean[] checker = new boolean[A.length];
        checker[A.length-1] = true;
        for(int i=A.length-2; i>=0; i--){
            if((A[i]+i)>=(A.length-1)){
                checker[i] = true;
            } else {
                boolean check = false;
                for(int j=1; j<=A[i]; j++){
                    if(checker[i+j]){
                        check = checker[i+j];
                    }
                }
                checker[i] = check;
            }
        }
        return checker[0];
    }


    public static void main(String[] args) {
        int[] A = {3,2,1,0,4};
        System.out.println(checkJump(A));
    }

}
