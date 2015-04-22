package question1_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import CtCILibrary.AssortedMethods;

public class QuestionB {
    
    // 1. Group anagrams
    // 
    public static String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    
    public static void sort(String[] array){
        Hashtable<String, ArrayList<String>> store = new Hashtable<String, ArrayList<String>>();
        // group words by anagram
        for(String s : array){
            String key = sortChars(s);
            if(!store.containsKey(key)){
                ArrayList<String> list = new ArrayList<String>();
                list.add(s);
                store.put(key, list);
            } else {
                ArrayList<String> anagrams = store.get(key);
                anagrams.add(s);
            }            
        }
        
        // convert hashtable to array
        int index = 0;
        for(String key : store.keySet()){
            ArrayList<String> list = store.get(key);
            for(String t : list){
                array[index] = t;
                index++;
            }
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        sort(array);
        System.out.println(AssortedMethods.stringArrayToString(array));
    }

}
