/**
    1.55    Pascal Triangle
    Given numRows, generate the first numRows of Pascal's triangle.
    For example, given numRows = 5,
    Return
     [
           [1],
          [1,1],
         [1,2,1],
        [1,3,3,1],
       [1,4,6,4,1]
     ]
    (leetcode118)
    (leetcodecpp15.8)
 */

package question1_55;

import java.util.ArrayList;

public class Question {

    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        current.add(1);
        result.add(current);
        for(int i=2; i<=numRows; i++){
            ArrayList<Integer> newRow = new ArrayList<Integer>();
            for(int j=0; j<i; j++){
                if(j==0 || j==i-1){
                    newRow.add(j, 1);
                } else {
                    newRow.add(j, current.get(j-1)+current.get(j));
                }
            }
            result.add(newRow);
            current=newRow;
        }
        
        return result;
    }
    
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = generate(5);
        for(ArrayList<Integer> row : result){
            for(Integer element : row){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
}
