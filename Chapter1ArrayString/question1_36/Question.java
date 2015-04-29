/**
    1.36    Two sorted array, find intersection and union
    For Example,
    A=[1,3,3,4,5,7], B=[2,3,5,6]
    Intersection: [3,5]
    Union: [1,2,3,4,5,6,7]
    http://www.geeksforgeeks.org/archives/6873
    http://www.leetcode.com/2010/03/here-is-phone-screening-question-from.html
 */

package question1_36;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public static List<Integer> intersection(int[] A, int[] B){
        List<Integer> result = new ArrayList<Integer>();
        int m =0,n=0;
        while(m<A.length && n<B.length){
            if(A[m]<B[n]){
                m++;
            } else if(A[m]>B[n]){
                n++;
            } else {
                int value = A[m];
                result.add(value);
                while(m<A.length && A[m]==value){
                    m++;
                }
                while(n<B.length && B[n]==value){
                    n++;
                }
            }
        }
        return result;
    }
    
    
    public static List<Integer> union(int[] A, int[] B){
        List<Integer> result = new ArrayList<Integer>();
        int m=0, n=0;
        while(m<A.length && n<B.length){
            if(A[m]<B[n]){
                result.add(A[m]);
                m++;
            } else if(A[m]>B[n]){
                result.add(B[n]);
                n++;
            } else {
                int val = A[m];
                result.add(val);
                while(m<A.length && A[m]==val){
                    m++;
                }
                while(n<B.length && B[n]==val){
                    n++;
                }
            }
        }
        while(m<A.length){
            result.add(A[m++]);
        }
        while(n<B.length){
            result.add(B[n++]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] A = {1,3,3,4,5,7};
        int[] B = {2,3,5,6};
        
        List<Integer> intersection = intersection(A, B);
        for(Integer val : intersection){
            System.out.print(val+" ");
        }
        
        System.out.println();
        
        List<Integer> union = union(A,B);
        for(Integer val : union){
            System.out.print(val+" ");
        }
    }

}
