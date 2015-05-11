/**
    4.19    Root-to-leaf Path Sum
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
    For example: Given the below binary tree and sum = 22,

    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
    (leetcode112)
    (leetcodecpp5.4.3)
 */

package question4_19;

import CtCILibrary.TreeNode;

public class Question {

    public static boolean checkSum(TreeNode root, int sum){
        return checkSum(root, 0, sum);
    }

    public static boolean checkSum(TreeNode root, int currentSum, int sum){
        if(root==null){
            return false;
        }
        currentSum+=root.data;
        if(root.left==null && root.right==null){
            if(currentSum==sum){
                return true;
            } else {
                return false;
            }
        }
        return checkSum(root.left, currentSum, sum) || checkSum(root.right, currentSum, sum);
    }

    public static void main(String[] args) {

    }

}
