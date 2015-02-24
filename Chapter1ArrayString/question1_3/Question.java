/**
 * CtCI1.4 Write a method to replace all spaces in a string with ‘%20’. You may assume that the string has sufficient space at the end of the string 
 * to hold the additional characters, and that you are given the "true" length of the string. (Note: if implementing in java, please use a character array so that you can perform this operation in place.)
 * Example: Input "Mr John Smith    "  Output: "Mr%20John%20Smith"
 * 
 */

package question1_3;

import CtCILibrary.AssortedMethods;

public class Question {
    // Assume string has sufficient free space at the end
    public static void replaceSpaces(char[] str, int length) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = length + spaceCount * 2;
        str[index] = '\0';
        for (i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
    
    public static void main(String[] args) {
        String str = "abc d e f";
        char[] arr = new char[str.length() + 3 * 2 + 1];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        replaceSpaces(arr, str.length());   
        System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
    }
}
