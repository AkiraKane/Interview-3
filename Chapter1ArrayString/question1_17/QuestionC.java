/**
    Design and implement a TwoSum class. It should support the following operations: add and find.
    add(input) – Add the number input to an internal data structure.
    find(value) – Find if there exists any pair of numbers which sum is equal to the value.
    For example,
    add(1); add(3); add(5); find(4)􏰁true; find(7)􏰁false
    (CleanCodeHandbook--3)   
 */

package question1_17;

import java.util.HashMap;

class TwoSum {
    private HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
    
    public void add(int input) {
      int count = table.containsKey(input) ? table.get(input) : 0;
      table.put(input, count + 1);
    }
    
    public boolean find(int val) {
        for(Integer key : table.keySet()){
            int num = key;
            int y = val - num;
            if (y == num) {
                return true;
            } else if (table.containsKey(y)) {
              return true;
            }
        }
      return false;
    }
  }


public class QuestionC {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
