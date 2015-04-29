/**
    3.13    Simplify Path
    Given an absolute path for a file (Unix-style), simplify it.
    For example,
    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"
    click to show corner cases.
    Corner Cases:
    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".
    (leetcode71)
    (leetcodecpp3.14)
 */
package question3_13;

import java.util.Stack;

public class Question {

    public static String simplifyPath(String path) {
        String[] parts = path.split("\\/");
        Stack<String> stack = new Stack<String>();
        
        for(String part : parts){
            if(part.equals(".")){
                continue;
            } else if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        
        String result="";
        while(!stack.isEmpty()){
            result = "/" + stack.pop()+result;
        }
        return result.substring(1);
    }
    
    
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
