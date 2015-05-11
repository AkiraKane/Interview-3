/**
    1.30    Repeated DNA Sequences
    All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
    Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
    For example,
    Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",  Return: ["AAAAACCCCC", "CCCCCAAAAA"].
    (leetcode187)
    http://bookshadow.com/weblog/2015/02/06/leetcode-repeated-dna-sequences/
 */

package question1_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question {

    public static List<String> findRepeatedSequences(String input){
        List<String> result = new ArrayList<String>();
        // maintain hashmap to check duplicated sequence
        // optimize the sequence storage in hashmap
        // A: 00, B:01, C:10, D:11
        // int has 32bits
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        int sum = 0;
        for(int i=0; i<input.length(); i++){
            int temp = sum<<2;
            sum = (temp + map(input.charAt(i))) & 0xFFFFF;  //???
            if(i<9){
                continue;
            }
            counts.put(sum, counts.containsKey(sum)?counts.get(sum)+1:1);
            if(counts.get(sum)==2){
                result.add(input.substring(i-9, i+1));
            }
        }
        return result;
    }

    public static int map(char c){
        int result=-1;
        if(c=='A'){
            result = 0;
        } else if(c=='C'){
            result = 1;
        } else if(c=='G'){
            result = 2;
        } else if(c=='T'){
            result = 3;
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = findRepeatedSequences(input);
        for(String sequence : result){
            System.out.println(sequence);
        }
    }
}
