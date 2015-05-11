/**
    6.12    Restore IP addresses
    Given a string containing only digits, restore it by returning all possible valid IP address combinations.
    For example:
    Given "25525511135",
    return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
    (leetcode93)
    (leetcodecpp10.6)
 */
package question6_12;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public static List<String> retore(String input){
        List<String> result = new ArrayList<String>();
        List<String> ip = new ArrayList<String>();
        int limit = 4;
        cutIp(input, 0, limit, ip, result);
        return result;
    }

    private static void cutIp(String input, int step, int limit, List<String> ip, List<String> result){


    }

    public static void main(String[] args) {


    }

}
