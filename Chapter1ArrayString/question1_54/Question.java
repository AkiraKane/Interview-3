/**
    1.54    Text Justification
    Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
    You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
    Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
    For the last line of text, it should be left justified and no extra space is inserted between words.
    For example,
    words: ["This", "is", "an", "example", "of", "text", "justification."]
    L: 16.
    Return the formatted lines as:
    ["This  is  an",
    "example  of text", 
    "justification.  " ]
    Note: Each word is guaranteed not to exceed L in length.
    Corner Cases:
    A line other than the last line might contain only one word. What should you do in this case?
    In this case, that line should be left-justified.
    (leetcode68)
    (leetcodecpp15.14)
 */
package question1_54;

import java.util.ArrayList;
import java.util.List;

public class Question {
    
    public static List<String> convert(String[] words, int L){
        List<List<String>> store = new ArrayList<List<String>>();
        int lineLength = 0;
        List<String> currentLine = new ArrayList<String>();
        currentLine.add(words[0]);
        lineLength+=words[0].length();
        
        for(int i=1; i<words.length; i++){
            String word = words[i];
            if(word.equals("justification.")){
                // this word must be in a new line
                store.add(currentLine);
                currentLine = new ArrayList<String>();
                currentLine.add(word);
                store.add(currentLine);
                break;
            } else {
                if((lineLength + word.length()+1) > L) {
                    // cannot add this word to the line
                    store.add(currentLine);
                    currentLine = new ArrayList<String>();
                    currentLine.add(word);
                    lineLength = word.length();
                } else {
                    // can add this word to the line
                    currentLine.add(words[i]);
                    lineLength += (word.length()+1);
                }
            }
        }
        
        List<String> result = new ArrayList<String>();
        for(List<String> line : store){
            int lengthOfChars = 0;
            for(int i=0; i<line.size(); i++){
                lengthOfChars+=line.get(i).length();
            }
            StringBuilder sb = new StringBuilder();
            int spaceNum = L-lengthOfChars;
            int basicSpaceNum = 0;
            int leftSpaceNum = 0;
            if(line.size()>1){
                basicSpaceNum = spaceNum/(line.size()-1);
                leftSpaceNum = spaceNum%(line.size()-1);
            }

            for(int i=0; i<line.size(); i++){
                if(i!=0){
                    // add some spaces
                    int extraSpaceNum = (leftSpaceNum>0) ? 1: 0;
                    leftSpaceNum--;
                    for(int j=0; j<basicSpaceNum+extraSpaceNum; j++){
                        sb.append(" ");
                    }
                }
                sb.append(line.get(i));
            }
            result.add(sb.toString());
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int L = 16;
        List<String> result = convert(words, L);
        for(String line : result){
            System.out.println(line);
        }
    }
}
