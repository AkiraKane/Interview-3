/**
    6.4     Generate Parentheses
    Implement an algorithm to print all valid (e g , properly opened and closed) combinations of n-pairs of parentheses
    EXAMPLE:
    input: 3 (e g , 3 pairs of parentheses) output: ()()(), ()(()), (())(), ((()))
    (CareerCups150 -- 9.6)
     
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. For example, given n = 3, a solution set is:
    "((()))", "(()())", "(())()", "()(())", "()()()"
    (leetcode22)
    (leetcodecpp10.9)
 */

package question6_4;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public static List<String> generateParens(int count){
        char[] str = new char[count*2];
        List<String> list = new ArrayList<String>();
        addParen(0, count, count, str, list);
        return list;
    }
    
    public static void addParen(int count, int left, int right, char[] str, List<String> list){
        if(left<0 || right<left){
            return;
        }
        if(left==0 && right==0){
            list.add(String.copyValueOf(str));
            return;
        } else {
            if(left>0){
                str[count]='(';
                addParen(count+1, left-1, right, str, list);
            }
            if(right>left){
                str[count]=')';
                addParen(count+1, left, right-1, str, list);
            }
        }
    }
    
    
    public static void main(String[] args) {
        List<String> list = generateParens(3);
        for(String s : list) {
            System.out.println(s);
        }
    }

}
