/**
    1.47    String Reorder Distance Apart
    Given a string of lowercase characters, reorder them such that the same characters are at least d from each other.
    Input: { a, b, b }, distance = 2
    Output: { b, a, b }
    http://www.leetcode.com/2010/05/here-is-another-google-phone-interview.html
 */
package question1_47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Question {

    public static List<List<Character>> reorderDistanceApart(char[] input, int distance){
        List<List<Character>> result = new ArrayList<List<Character>>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : input){
            map.put(c, map.containsKey(c)?map.get(c)+1:1);
        }
        List<Character> order = new ArrayList<Character>();
        reorder(order, distance, (HashMap<Character, Integer>)map.clone(), input.length, result);
        return result;
    }

    public static void reorder(List<Character> order, int distance, HashMap<Character, Integer> map, int total, List<List<Character>> result){
        if(order.size()==total){
            result.add(order);
            return;
        }
        Iterator<Character> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            Character newChar = iterator.next();
            boolean isValid = true;
            // check if it is valid to put this char at this position
            for(int i=0; i<(distance-1); i++){
                if(order.size()-1-i>=0){
                    char c = order.get(order.size()-1-i);
                    if(c==newChar){
                        isValid = false;
                        break;
                    }
                }
            }
            if(isValid){
                List<Character> newOrder = new ArrayList<Character>();
                newOrder.addAll(order);
                newOrder.add(newChar);
                if(map.get(newChar)==1){
                    map.remove(newChar);
                } else if(map.get(newChar)>1){
                    map.put(newChar, map.get(newChar)-1);
                }
                reorder(newOrder, distance, (HashMap<Character, Integer>)map.clone(), total, result);
            }
        }
    }

    public static void main(String[] args) {
        char[] input = { 'a', 'b', 'b' };
        int distance = 2;
        List<List<Character>> result = reorderDistanceApart(input, distance);
        for(List<Character> list : result){
            for(Character c : list){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
}
