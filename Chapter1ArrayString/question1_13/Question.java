/**
    1.13    Permutation Sequence
    The set [1,2,3,…,n] contains a total of n! unique permutations.
    By listing and labeling all of the permutations in order,
    We get the following sequence (ie, for n = 3):
    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
    Given n and k, return the kth permutation sequence.
    Note: Given n will be between 1 and 9 inclusive.
    (leetcode60)
    (leetcodecpp2.1.13)
 */
package question1_13;

import java.util.ArrayList;

public class Question {

    public static String getPermutation(int n, int k){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            list.add(i+1);
        }
        StringBuilder sb = new StringBuilder();
        
        int value = k;
        for(int i=n-1; i>0;i--){
            int fac = factorial(i);
            int first = value/fac;
            value = value%fac;
            sb.append(list.get(first));
            list.remove(first);
        }
        sb.append(list.get(value)); //???
        return sb.toString();
    }
    
    public static int factorial(int num) {
        int result = 1;
        while(num>0){
            result*=num;
            num--;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(getPermutation(4, 10));
    }

}
