/**
    4.34    Binary tree right side view
    Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
    For example:
    Given the following binary tree,
      1       <---
     / \
    2   3     <---
     \   \
      5   4   <---

    You should return [1, 3, 4].
    (Leetcode199)
 */

package question4_34;

import java.util.ArrayList;
import java.util.List;

import CtCILibrary.TreeNode;

public class Question {


    // BFS
    public static List<Integer> rightside(TreeNode root){
        List<Integer> view = new ArrayList<Integer>();

        List<TreeNode> currentList = new ArrayList<TreeNode>();
        currentList.add(root);
        while(!currentList.isEmpty()){
            view.add(currentList.get(0).data);
            List<TreeNode> newList = new ArrayList<TreeNode>();
            for(TreeNode node : currentList){
                if(node.right!=null){
                    newList.add(node.right);
                }
                if(node.left!=null){
                    newList.add(node.left);
                }
            }
            currentList = newList;
        }
        return view;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(4);

        List<Integer> view = rightside(root);
        for(Integer val : view){
            System.out.print(val+" ");
        }
    }

}
