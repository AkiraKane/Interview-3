/**
    1.12    Next Permutation
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
    The replacement must be in-place, do not allocate extra memory.
    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
    (leetcode31)
    (leetcodecpp2.1.12)
 */

package question1_12;

import java.util.ArrayList;
import java.util.Collections;

public class Question {

    public static void nextPermutation(int[] num){
        // from right to left
        // find the first descending pair
        
        for(int i=num.length-1; i>0; i--){
            if(num[i]>num[i-1]){
                ArrayList<Integer> newList = rearrange(num, i-1, num[i-1]);
                int start = i-1;
                for(Integer val : newList){
                    num[start++] = val;
                }
                break;
            }
        }
    }
    
    public static ArrayList<Integer> rearrange(int[] num, int start, int target){
        // find the num, next to target, in the range from start to the right end
        // this num will the first number, following by all the other numbers in ascending order
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=start; i<num.length; i++){
            result.add(num[i]);
        }
        Collections.sort(result);
        int firstNum = 0;
        for(int i=0; i<result.size(); i++){
            if(result.get(i)==target){
                firstNum=result.get(i+1);
                result.remove(i+1);
                break;
            }
        }
        result.add(0, firstNum);
        return result;
    }
    
    
    public static void main(String[] args) {
        int[] num = {1,2,4,3};
        nextPermutation(num);
        for(Integer n : num){
            System.out.print(n+" ");
        }
    }

}
