/**
    6.23    Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent), write code to calculate the number of ways of representing n cents.
    (CareerCups150 -- 9.8)
 */

package question6_23;

public class Question {

    public static int makeChange(int n){
        int[] denoms = {25, 10, 5, 1};
        return makeChange(n, denoms, 0);
    }

    public static int makeChange(int amount, int[] denoms, int index){
        if(index >= denoms.length-1){
            // one denom remaining
            // only one way to do it
            return 1;
        }
        int denomAmount = denoms[index];
        int ways = 0;
        for(int i=0; i*denomAmount<=amount; i++){
            int amountRemaining = amount - i*denomAmount;
            ways+=makeChange(amountRemaining, denoms, index+1);
        }
        return ways;
    }

    public static void main(String[] args) {

    }

}
