/**
    1.46    Set Matrix Zeros        
    Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
    (CareerCups150--1.7)
    Given a mxn matrix, if an element is 0, set its entire row and column to 0. Do it in place.
    Follow up:
    Did you use extra space?
    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?
    (leetcode73)
    (leetcodecpp2.1.20)
 */
package question1_46;

import CtCILibrary.AssortedMethods;

public class Question {

    public static void setZeros(int[][] matrix) {
        
        
        
        
    }
    
    public static void main(String[] args) {
        int nrows = 10;
        int ncols = 15;
        int[][] matrix1 = AssortedMethods.randomMatrix(nrows, ncols, 0, 100);
        
        AssortedMethods.printMatrix(matrix1);
        
        setZeros(matrix1);
        
        System.out.println();
        
        AssortedMethods.printMatrix(matrix1);
    }

}
