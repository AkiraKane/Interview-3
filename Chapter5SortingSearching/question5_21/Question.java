/**
    5.21    K-way merge  (SureInterview)
    Given k sorted arrays, merge them into one sorted array
    1. time and space complexity.
    2. optimise for only two arrays.
    http://www.site.uottawa.ca/~nat/Courses/DFS-Course/DFS-Lecture-9/tsld013.htm
 */
package question5_21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Question {

    public static List<Integer> merge(List<List<Integer>> lines){
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        // value-> list of lineNumber
        HashMap<Integer, List<Integer>> map1 = new HashMap<Integer, List<Integer>>();
        // lineNumber-> index in that line
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        
        for(int i=0; i<lines.size(); i++){
            List<Integer> line = lines.get(0);
            minHeap.add(line.get(0));
            if(map1.containsKey(line.get(0))){
                map1.get(line.get(0)).add(i);
            } else {
                List<Integer> lineNumbers = new ArrayList<Integer>();
                lineNumbers.add(i);
                map1.put(line.get(0), lineNumbers);
            }
            map2.put(i, 0);
        }
        
        while(!minHeap.isEmpty()){
            Integer smallest = minHeap.poll();
            result.add(smallest);
            
            List<Integer> lineNumbers = map1.get(smallest);
            int lineNumber = lineNumbers.remove(0);
            if(lineNumbers.size()==0){
                map1.remove(smallest);
            }
            
            List<Integer> line = lines.get(lineNumber);
            int newIndex= map2.get(lineNumber)+1;
            if(newIndex<line.size()){
                minHeap.add(line.get(newIndex));
                if(map1.containsKey(line.get(newIndex))){
                    map1.get(line.get(newIndex)).add(lineNumber);
                } else {
                    List<Integer> newLineNumbers = new ArrayList<Integer>();
                    newLineNumbers.add(lineNumber);
                    map1.put(line.get(newIndex), newLineNumbers);
                }
                map2.put(lineNumber, newIndex);
            }
        }
        
        return result;
    }
    
    
    public static void main(String[] args) {

    }

}
