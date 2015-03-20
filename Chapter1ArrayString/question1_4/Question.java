/**
 * 1.4  Write a method to replace all spaces in a string with ‘%20’. 
 * You may assume that the string has sufficient space at the end of the string to hold the additional characters, and that you are given the “true” length of the string.(Note: if implementing in java, please use a character array so that you can perform this operation in place.)
 * Implement in place!
 * Example
 * Input:  “Mr John Smith    ”
 * Output: “Mr%20John%20Smith”
 * (CareerCups150--1.4)
 */

package question1_4;

import CtCILibrary.AssortedMethods;

public class Question {
    public static void replaceSpaces(char[] str, int length) {
        int index = str.length-1;
        for(int i=length-1; i>=0;i--){
            char letter = str[i];
            if(letter==' '){
                str[index]='0';
                str[index-1]='2';
                str[index-2]='%';
                index = index-3;
            } else {
                str[index--]=str[i];
            }
        }
    }
    
    public static void main(String[] args) {
        String str = "abc d e f";
        char[] arr = new char[str.length() + 3 * 2];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        replaceSpaces(arr, str.length());
        System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
        
//        char[] chars = {'a','b', '\0'};
//        System.out.println(new String(chars));
//        System.out.println(new String(chars).length());
    }
}
