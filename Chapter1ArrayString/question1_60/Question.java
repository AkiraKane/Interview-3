/**
    1.60    Candy
    There are N children standing in a line. Each child is assigned a rating value.
    You are giving candies to these children subjected to the following requirements:
    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    What is the minimum candies you must give?
    (leetcode135)
    (leetcode2.1.22)
 */
package question1_60;

public class Question {

    
    public static int candy(int[] ratings){
        int n = ratings.length;
        int[] increment = new int[n];
        
        for(int i=1,inc=1; i<n; i++) {
            if(ratings[i]>ratings[i+1]){
                increment[i] = Math.max(inc++, increment[i]);
            } else {
                inc=1;
            }
        }
        
        for(int i=n-2,inc=1; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                increment[i] = Math.max(inc++, increment[i]);
            } else {
                inc = 1;
            }
        }
        
        int accumulate = 0;
        for(int i=0; i<n; i++){
            accumulate+=increment[i];
        }
        return accumulate;
    }
    
    public static void main(String[] args) {

    }

}
