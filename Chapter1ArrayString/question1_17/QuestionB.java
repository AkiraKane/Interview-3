/**
    Similar to Question [1. Two Sum], except that the input array is already sorted in ascending order.
    (CleanCodeHandbook--2)
    Design an algorithm to find all pairs of integers within an array which sum to a specified value.    
    (CareerCups150--17.12)
 */

package question1_17;

public class QuestionB {

    // sorted array
    public static int[] twoSum(int[] array, int sum){
        int left = 0;
        int right = array.length -1;
        while(left<right){
            int s = array[left] + array[right]; 
            if(s==sum){
                return new int[]{left, right};
            }else if(s<sum){
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] test = {-2, -1, 0, 1, 4, 6, 9};
        int[] result = twoSum(test, 2);
        if(result!=null){
            System.out.println(result[0] + "," + result[1]);
        }
    }

}
