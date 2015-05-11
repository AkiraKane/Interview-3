/**
    6.20    A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs.
    (CareerCups150 -- 9.1)
 */

package question6_20;

public class Question {

    public static int runStepRecursive(int n){
        if(n<0){
            return 0;
        } else if(n==0){
            return 1;
        }
        return runStepRecursive(n-1)+runStepRecursive(n-2)+runStepRecursive(n-3);
    }
    
    public static int runStepDP(int n){
        int[] count = new int[n+1];
        count[0]=1;
        count[1]=1;
        count[2]=2;
        for(int i=3; i<=n; i++){
            count[i]=count[i-3]+count[i-2]+count[i-1];
        }
        return count[n];
    }
    
    
    public static void main(String[] args) {
        System.out.println(runStepRecursive(3)+ " "+ runStepDP(3));
    }
}
