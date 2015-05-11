/**
    1.37    Missing Ranges
    Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
    For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
    (CleanCodeHandbook--12)
 */

package question1_37;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public static List<String> missingRanges(int[] elements){
        List<String> ranges = new ArrayList<String>();
        for(int i=0; i<(elements.length-1); i++){
            if(elements[i+1]==(elements[i]+2)){
                ranges.add(Integer.toString(elements[i]+1));
            } else if(elements[i+1]>elements[i]+2){
                ranges.add(Integer.toString(elements[i]+1) + "->" + Integer.toString(elements[i+1]-1));
            }
        }
        if(elements[elements.length-1]==98){
            ranges.add("99");
        } else if(elements[elements.length-1]<98){
            ranges.add(Integer.toString(elements[elements.length-1]+1) + "->99");
        }
        return ranges;
    }

    public static void main(String[] args) {
        int[] elements = {0,1,3,50,75};
        List<String> ranges = missingRanges(elements);
        for(String range : ranges){
            System.out.println(range);
        }
    }
}
