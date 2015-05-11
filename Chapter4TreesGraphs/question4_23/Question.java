 /**
    4.23    Binary Tree Maximum Path Sum
    Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
    For example, given the below binary tree.
         1
        / \
       2   4
      / \
     2   3
    The highlighted path yields the maximum sum 10.
    (CleanCodeHandbook--31)
    (leetcode124)
    (leetcodecpp5.4.5)
 */
package question4_23;

import java.util.ArrayList;
import java.util.List;

import CtCILibrary.TreeNode;

public class Question {

    public static int maxPathSum(TreeNode root){
        int maxSum = 0;
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        while(!list.isEmpty()){
            TreeNode node = list.remove(0);
            int currentMaxSum = maxSinglePathSum(node.left)+node.data+maxSinglePathSum(node.right);
            if(currentMaxSum>maxSum){
                maxSum = currentMaxSum;
            }
            if(node.left!=null){
                list.add(node.left);
            }
            if(node.right!=null){
                list.add(node.right);
            }
        }
        return maxSum;
    }

    public static int maxSinglePathSum(TreeNode root){
        if(root==null){
            return 0;
        }
        return root.data+Math.max(maxSinglePathSum(root.left), maxSinglePathSum(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        System.out.print(maxPathSum(root));
    }
}
