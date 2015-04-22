/**
    Given an integer n, generate a square matrix filled with elements from 1 to n in spiral order.
    For example,
    Given n = 3, (3x3 matrix)
    You should return the following matrix:
    [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ], 
     [ 7, 6, 5 ]
    ]
    (leetcode59)
    (leetcodecpp15.11)
 */

package question1_48;

public class QuestionB {
    
    public static int[][] matrix(int n){
        int[][] matrix = new int[n][n];
        int count = 1;
        for(int i=0; i<=(n-1)/2; i++){
            if(2*i+1==n){
                matrix[i][i] = count;
                break;
            }
            
            // left->right
            for(int j=i; j<n-1-i; j++) {
                matrix[i][j] = count++;
            }
            
            // top->bottom
            for(int j=i; j<n-1-i; j++){
                matrix[j][n-1-i] = count++;
            }
            
            // right->left
            for(int j=n-1-i; j>i; j--){
                matrix[n-1-i][j] = count++;
            }
            
            // bottom->top
            for(int j=n-1-i; j>i; j--){
                matrix[j][i] = count++;
            }
        }
        return matrix;
    }
    
    
    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = matrix(n);
        
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
