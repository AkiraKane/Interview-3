/**
    1.49    ZigZag Conversion
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
    (you may want to display this pattern in a fixed font for better legibility)
    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    Write the code that will take a string and make this conversion given a number of rows:
    string convert(string text, int nRows);
    convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
    (leetcode6)
    (leetcodecpp15.12)
 */
package question1_49;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public static String zigZagConvert(String input, int row){
        List<List<Character>> lines = new ArrayList<List<Character>>();
        for(int i=0; i<row; i++){
            lines.add(i, new ArrayList<Character>());
        }
        
        int period = 2*row-2;
        for(int i=0; i<input.length(); i++) {
            int index = i%period;
            if(index<row){
                lines.get(index).add(input.charAt(i));
            } else {
                int distanceFromBottomLine = (index-row+1);
                int lineIndex = (row-1-distanceFromBottomLine);
                lines.get(lineIndex).add(input.charAt(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(List<Character> line : lines){
            for(Character c : line){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        System.out.println(zigZagConvert("PAYPALISHIRING", 3));
    }

}
