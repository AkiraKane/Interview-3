/**
    1.11    Anagrams
    Write a method to sort an array of strings so that all the anagrams are next to each other.
    (CareerCups150 -- 11.2)
    
    Given an array of strings, return all groups of strings that are anagrams.
    Note: All inputs will be in lower-case.
    (leetcode49)
    (leetcodecpp3.13)
 */
package question1_11;

import java.util.Arrays;
import java.util.Comparator;

import CtCILibrary.AssortedMethods;

class AnagramComparator implements Comparator<String> {
    public String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    
    public int compare(String s1, String s2) {
        return sortChars(s1).compareTo(sortChars(s2));
    }
}

public class Question {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        System.out.println(AssortedMethods.stringArrayToString(array));
        Arrays.sort(array, new AnagramComparator());
        System.out.println(AssortedMethods.stringArrayToString(array));
    }

}
