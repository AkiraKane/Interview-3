/**
    4.3     Binary Tree Level-Order Traversal Using Depth First Search (DFS)
    Given a binary tree, print out the tree in level order (ie, from left to right, level by level).
    Output a newline after the end of each level. Breadth First Search (BFS) is not allowed.

    For example, the level order output of the tree above is:

    http://articles.leetcode.com/2010/09/binary-tree-level-order-traversal-using_17.html
 */

package question4_3;

import CtCILibrary.TreeNode;

public class Question {

    public static void printLevelOrder(TreeNode root){
        int height = maxHeight(root);
        for(int level=1; level<=height; level++){
            printLevel(root, level);
            System.out.println();
        }
    }

    private static void printLevel(TreeNode node, int level){
        if(node==null){
            return;
        }
        if(level==1){
            System.out.print(node.data+" ");
        } else {
            printLevel(node.left, level-1);
            printLevel(node.right, level-1);
        }
    }

    private static int maxHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(maxHeight(root.left), maxHeight(root.right))+1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);

        printLevelOrder(root);
    }

}
