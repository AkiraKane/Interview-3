/**
    1.43    Longest consecutive sequence
    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    For example,
    Given [100, 4, 200, 1, 3, 2],
    The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
    Your algorithm should run in O(n) complexity.
    (leetcode128)
    (leetcodecpp2.1.6)
 */
package question1_43;

import java.util.HashMap;
import java.util.Iterator;

public class Question {

    public static int longestConsecutiveSequence(int[] input){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(Integer element : input){
            map.put(element, map.containsKey(element) ? map.get(element)+1 : 1);
        }

        int maxLength = 0;
        while(!map.isEmpty()){
            int randomElement=0;
            Iterator<Integer> iterator = map.keySet().iterator();
            if(iterator.hasNext()){
                randomElement = iterator.next();
            }
            // find the longest consecutive sequence around this random element
            int length=map.get(randomElement);
            map.remove(randomElement);
            int toLeftVal = randomElement-1;
            int toRightVal = randomElement+1;
            while(map.containsKey(toLeftVal)){
                map.remove(toLeftVal);
                length++;
                toLeftVal--;
            }
            while(map.containsKey(toRightVal)){
                map.remove(toRightVal);
                length++;
                toRightVal++;
            }

            if(length>maxLength){
                maxLength = length;
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int[] input = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveSequence(input));
    }
}
