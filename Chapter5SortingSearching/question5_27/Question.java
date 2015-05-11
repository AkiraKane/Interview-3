/**
    5.27    Largest Number
    Given a list of non-negative integers, arrange them such that they form the largest number.
    For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
    Note: The result may be very large, so you need to return a string instead of an integer.
    (leetcode179)
 */

package question5_27;

import java.util.Arrays;
import java.util.Comparator;

class MyComparator implements Comparator<String> {
    public int compare(String a, String b){
        int length = Math.min(a.length(), b.length());
        for(int i=0; i<length; i++){
            if(a.charAt(i)>b.charAt(i)){
                return 1;
            } else if(a.charAt(i)<b.charAt(i)){
                return -1;
            }
        }
        if(a.length()>length){
            for(int i=length; i<a.length(); i++){
                if(a.charAt(i)>a.charAt(0)){
                    return 1;
                } else if(a.charAt(i)<a.charAt(0)){
                    return -1;
                }
            }
            return 0;
        } else if(b.length()>length){
            for(int i=length; i<b.length(); i++){
                if(b.charAt(i)>b.charAt(0)){
                    return -1;
                } else if(b.charAt(i)<b.charAt(0)){
                    return 1;
                }
            }
            return 0;
        }
        return 0;
    }
}

public class Question {
    public static void main(String[] args) {
        String[] array = {"91", "3", "30", "34", "5", "9"};
        Arrays.sort(array, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for(String ele : array){
            sb.append(ele);
        }
        System.out.println(sb.toString());
    }
}
