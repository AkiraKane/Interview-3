/**
    7.1     Single Number
    Given an array of integers, every element appears twice except for one. Find that single one.
    (CleanCodeHandbook--33)
    (leetcode136)
    (leetcode2.1.23)
 */
package question7_1;

public class Question {

    public static int singleNumber(int[] arr){
        int num=0;
        for(int element : arr){
            num ^= element;
        }
        return num;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,2,1};
        System.out.println(singleNumber(arr));
    }

}
