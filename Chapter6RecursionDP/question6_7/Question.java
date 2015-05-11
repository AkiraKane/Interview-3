/**
    6.7     Write an algorithm to print all ways of arranging eight queens on a chess board, so that none of them share the same row, column or diagonal.
    (CareerCups150 -- 9.9)

    N-Queens
    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.


    Given an integer n, return all distinct solutions to the n-queens puzzle.
    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
    For example,
    There exist two distinct solutions to the 4-queens puzzle:
    [
      [''.Q..'',
       ''...Q'',
       ''Q...'',
       ''..Q.''],
      [''..Q.'',
       ''Q...'',
       ''...Q'',
       ''.Q..'']
    ]
    (leetcode51)
    (leetcodecpp10.4)

    Follow up for N-Queens problem.
    Now, instead outputting board configurations, return the total number of distinct solutions.
 */

package question6_7;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public static void placeQueens(int row, Integer[] columns, List<Integer[]> results, int N){
        if(row==N){
            results.add(columns.clone());
        } else {
            for(int col = 0; col<N; col++){
                if(checkValid(columns, row, col)){
                    columns[row]=col;
                    placeQueens(row+1, columns, results, N);
                }
            }
        }
    }


    public static void printBoard(Integer[] columns, int N){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(columns[i]==j){
                    System.out.print("Q");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static boolean checkValid(Integer[] columns, int row1, int column1){
        for(int row=0; row<row1; row++){
            int column = columns[row];

            if(column==column1){
                return false;
            }

            int columnDistance = Math.abs(column-column1);
            int rowDistance = row1-row;
            if(columnDistance==rowDistance){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 4;
        List<Integer[]> results = new ArrayList<Integer[]>();
        Integer[] columns = new Integer[N];
        placeQueens(0, columns, results, N);

        // print board
        for(int i=0; i<results.size(); i++){
            Integer[] board = results.get(0);
            printBoard(board, N);
            System.out.println();
        }

        System.out.println(results.size());
    }
}
