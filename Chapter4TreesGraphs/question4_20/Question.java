/**
    4.20    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    For example:
    Given the below binary tree and sum = 22,

    return
    [ [5,4,11,2], [5,8,4,5] ]

    (leetcode113)
    (leetcodecpp5.4.4)
 */
package question4_20;

import java.util.ArrayList;
import java.util.List;

import CtCILibrary.TreeNode;

public class Question {

    public static List<List<Integer>> findPaths(TreeNode root, int sum){
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        findPaths(root, path, sum, paths);
        return paths;
    }

    public static void findPaths(TreeNode root, List<Integer> path, int sum, List<List<Integer>> paths){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            int s = 0;
            for(Integer val : path){
                s+=val;
            }
            if(s==sum){
                paths.add(path);
            }
        } else {
            if(root.left!=null){
                List<Integer> newPath = new ArrayList<Integer>();
                newPath.addAll(path);
                findPaths(root.left, newPath, sum, paths);
            }
            if(root.right!=null){
                List<Integer> newPath = new ArrayList<Integer>();
                newPath.addAll(path);
                findPaths(root.right, newPath, sum, paths);
            }
        }
    }

    public static void main(String[] args) {


    }

}
