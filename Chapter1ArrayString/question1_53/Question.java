/**
    1.53    Design a method to find the frequency of occurrences of any given word in a book. 
    (CareerCups150--17.9)
 */

package question1_53;

import java.util.Hashtable;

import CtCILibrary.AssortedMethods;

public class Question {

    // Time: , Space:
    public static int getFrequency(Hashtable<String, Integer> dictionary, String word){
        if(dictionary==null || word==null) return -1;
        
        word=word.toLowerCase();
        if(dictionary.containsKey(word)){
            return dictionary.get(word);
        }
        return 0;
    }
    
    public static Hashtable<String, Integer> setupDictionary(String[] book){
        Hashtable<String, Integer> table = new Hashtable<String, Integer>();
        for(String word : book){
            word = word.toLowerCase();
            if(word.trim()!=""){
                if(table.containsKey(word)){
                    table.put(word, table.get(word)+1);
                } else {
                    table.put(word, 1);
                }
            }
        }
        return table;
    }
    
    public static void main(String[] args) {
        String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
        Hashtable<String, Integer> dictionary = setupDictionary(wordlist);
        
        String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
        for (String word : words) {
            System.out.println(word + ": " + getFrequency(dictionary, word));
        }
    }
}
