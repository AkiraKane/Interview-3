/**
    4.7     Minimum Depth of Binary Tree
    Given a binary tree, find its minimum depth.
    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
    (CleanCodeHandbook--27)
    (leetcode111)
    (leetcodecpp5.4.1)
 */
package question4_7;

import CtCILibrary.TreeNode;

public class Question {
    
    public static int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return minDepth(root.right)+1;
        }
        if(root.right==null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
        
    }
    
    public static void main(String[] args) {

    }

}
