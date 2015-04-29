/**
    5.6     Searching a 2D Sorted Matrix Part
    Write an efficient algorithm that searches for a value in an n x m table (two-dimensional array). This table is sorted along the rows and columns — that is,
    Table[i][j] ≤ Table[i][j + 1],
    Table[i][j] ≤ Table[i + 1][j]
     (CareerCups150 -- 11.6)
     
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
    For example,
    Consider the following matrix:
    [
     [1,   3,  5,  7],  
     [10, 11, 16, 20],  
     [23, 30, 34, 50]
    ]
    Given target = 3, return true.
    (leetcode74)
    (leetcodecpp7.3)
    http://www.leetcode.com/2010/10/searching-2d-sorted-matrix.html         
    http://articles.leetcode.com/2010/10/searching-2d-sorted-matrix-part-ii.html
    http://articles.leetcode.com/2010/10/searching-2d-sorted-matrix-part-iii.html
 */

package question5_6;

import CtCILibrary.AssortedMethods;

public class Question {

    public static boolean findElement(int[][] matrix, int elem){
        int row = 0;
        int col = matrix[0].length -1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==elem){
                return true;
            } else if(matrix[row][col] > elem){
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
    

    
    
    public static void main(String[] args) {
        int M=10;
        int N=5;
        int[][] matrix = new int[M][N];
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                matrix[i][j] = 10*i+j;
            }
        }
        
        AssortedMethods.printMatrix(matrix);
        
        
        
    }

}
