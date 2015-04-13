/**
 * If The String is given as an array of characters. How to reverse this array.
 * Return should be a string.
 */

package question1_6;

public class QuestionB {
    public static void swap(char[] chars, int index1, int index2){
        char temp = chars[index1];
        chars[index1]=chars[index2];
        chars[index2]=temp;
    }
    
    public static String reverse(char[] original){
        int startIndex=0;
        int endIndex=original.length-1;
        while(startIndex<endIndex){
            swap(original, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
        
        return new String(original);
    }

    public static void main(String[] args) {
        char[] chars= {'h','e','l','l','o'};
        System.out.println( reverse(chars) );
    }

}