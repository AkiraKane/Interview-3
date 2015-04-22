/**
    1.48    Spiral Matrix
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    For example, given the following matrix:
    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]                                                           
    You should return [1,2,3,6,9,8,7,4,5].
    (CleanCodeHandbook--35)
    (leetcode54)
    (leetcodecpp15.10)
    http://www.leetcode.com/2010/05/printing-matrix-in-spiral-order.html
 */

package question1_48;

public class Question {

    public static int[] printMatrix(int[][] matrix, int M, int N){
        int[] result = new int[M*N];
        int minLength = (M<N) ? M : N;
        int count=0;
        for(int delta=0; delta<=(minLength-1)/2; delta++){
            if(delta==(minLength-1-delta)){
                if(minLength==M){
                    // single row
                    for(int i=delta; i<N-delta; i++){
                        result[count++]=matrix[delta][i];
                    }
                } else {
                    // single column
                    for(int i=delta; i<M-delta;i++){
                        result[count++]=matrix[i][delta];
                    }
                }
                break;
            }
            
            // left->right
            for(int i=delta; i<N-1-delta; i++){
                result[count++] = matrix[delta][i];
            }
            // top->bottom
            for(int i=delta; i<M-1-delta; i++){
                result[count++] = matrix[i][N-1-delta];
            }
            
            // right->left
            for(int i=N-1-delta; i>delta; i--){
                result[count++] = matrix[M-1-delta][i];
            }
            
            // bottom->top
            for(int i=M-1-delta; i>0; i--){
                result[count++] = matrix[i][delta];
            }
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12}};
        int[] result = printMatrix(matrix, 3, 4);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
}
