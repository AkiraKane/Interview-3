/**
    8.36    Gray Code
    The gray code is a binary numeral system where two successive values differ in only one bit.
    Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
    For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
    00 - 0
    01 - 1
    11 - 3
    10 - 2
    Note:
    For a given n, a gray code sequence is not uniquely defined.
    For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
    For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
    (leetcode89)
    (leetcodecpp2.1.19)
 */

package question8_36;

import java.util.ArrayList;

public class Question {
    
    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n==1){
            result.add(0);
            result.add(1);
            return result;
        }
        ArrayList<Integer> lastNums = grayCode(n-1);
        result.addAll(lastNums);
        for(Integer num : lastNums){
            result.add(num|(1<<(n-1)));
        }
        return result;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> result = grayCode(4);
        for(Integer num : result){
            System.out.print(num+" ");
        }
    }
}
