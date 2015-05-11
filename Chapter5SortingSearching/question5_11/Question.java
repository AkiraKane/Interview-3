/**
    5.11    Search Insert Position
    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    You may assume no duplicates in the array.
    Here are few examples.
    [1,3,5,6], 5 → 2
    [1,3,5,6], 2 → 1
    [1,3,5,6], 7 → 4
    [1,3,5,6], 0 → 0
    (CleanCodeHandbook--48)
    (leetcode35)
    (leetcodecpp7.2)
 */
package question5_11;

public class Question {

    public static int insert(int[] array, int target){

        int position = -1;
        int i;
        for(i=0; i<=array.length; i++){
            if(array[i]>=target){
                break;
            }
        }
        position=i;
        return position;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,6};
        int target = 5;
        System.out.print(insert(array, target));
    }

}
