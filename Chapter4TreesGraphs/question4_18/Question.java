/**
    4.18    Largest Binary Search Tree (BST) in a Binary Tree
    Given a binary tree, find the largest Binary Search Tree (BST), where largest means BST with largest number of nodes in it.
    The largest BST may or may not include all of its descendants.
    http://articles.leetcode.com/2010/11/largest-binary-search-tree-bst-in_22.html
    http://articles.leetcode.com/2010/11/largest-binary-search-tree-bst-in.html
 */
package question4_18;

import java.util.ArrayList;
import java.util.List;

import CtCILibrary.TreeNode;

public class Question {

    public static int largestBST(TreeNode root){
        int max = 0;
        // go through all nodes in binary tree
        // find the largest size of BST rooted from this node
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove(0);
            int currentLargestBST = findLargestBST(node).size();
            if(currentLargestBST>max){
                max = currentLargestBST;
            }
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return max;
    }

    public static List<TreeNode> findLargestBST(TreeNode root){
        List<TreeNode> list = new ArrayList<TreeNode>();
        findLargestBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, list);
        return list;
    }

    public static void findLargestBST(TreeNode root, int leftBound, int rightBound, List<TreeNode> list){
        if(root==null){
            return;
        }
        if(root.data>=leftBound && root.data<rightBound){
            list.add(root);
            findLargestBST(root.left, leftBound, root.data, list);
            findLargestBST(root.right, root.data, rightBound, list);
        }
    }

    public static void main(String[] args) {


    }

}
