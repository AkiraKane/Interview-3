/**
    1.9     Rotate Matrix
    Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees Can you do this in place?   
    (CareerCups150--1.6)
    (leetcode48)
    (leetcodecpp2.1.16)
 */

package question1_9;

import CtCILibrary.AssortedMethods;

public class Question {
    
    public static void rotate(int[][] matrix, int n){
        for(int layer=0;layer<n/2; layer++){
            int first = layer;
            int last = n-1-layer;
            for(int i=first;i<last;i++){
                int offset = i-first;
                int top = matrix[first][i];
                
                // left -> top
                matrix[first][i] = matrix[last-offset][first];
                
                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];
                
                // right -> bottom
                matrix[last][last-offset] = matrix[i][last];
                
                // top -> right
                matrix[i][last] = top;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = AssortedMethods.randomMatrix(10, 10, 0, 9);
        AssortedMethods.printMatrix(matrix);
        rotate(matrix, 10);
        System.out.println();
        AssortedMethods.printMatrix(matrix);
    }
}