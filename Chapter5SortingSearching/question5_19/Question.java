/**
    5.19    Sort Colors
    Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
    Note:
    You are not suppose to use the library's sort function for this problem.
    Follow up:
    A rather straight forward solution is a two-pass algorithm using counting sort.
    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
    Could you come up with an one-pass algorithm using only constant space?
    (leetcode75)
    (leetcodecpp6.7)
    Dutch national flag problem
    http://en.wikipedia.org/wiki/Dutch_national_flag_problem
 */

package question5_19;

public class Question {

    public static void sortTwoPass(int[] array){
        int numZero = 0;
        int numOne = 0;
        int numTwo = 0;
        
        for(int i=0; i<array.length; i++){
            if(array[i]==0){
                numZero++;
            } else if(array[i]==1){
                numOne++;
            } else if(array[i]==2){
                numTwo++;
            }
        }
        int index = 0;
        while(numZero>0){
            array[index++] = 0;
            numZero--;
        }
        while(numOne>0){
            array[index++] = 1;
            numOne--;
        }
        while(numTwo>0){
            array[index++] = 2;
            numTwo--;
        }
        
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
    
    public static void sortOnePass(int[] array){
        // elements lefter than indexZeo are 0
        int indexZero = 0;
        
        // elements righter than indexTwo are 2
        int indexTwo = array.length-1;
        
        int i=0;
        while(i<=indexTwo) {
            if(array[i]==0){
                // swap i,left
                array[i]=array[indexZero];
                array[indexZero++]=0;
                if(i<indexZero){
                    i=indexZero;
                }
            } else if(array[i]==2){
                array[i]=array[indexTwo];
                array[indexTwo--]=2;
            } else if(array[i]==1){
                i++;
            }
        }
        
        for(int j=0; j<array.length; j++){
            System.out.print(array[j]+" ");
        }
    }

    
    public static void main(String[] args) {
        int[] array = {1,2,0,1,1,2};
        sortOnePass(array);
    }

}
