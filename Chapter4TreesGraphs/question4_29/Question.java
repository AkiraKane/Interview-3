/**
    4.29    Print Edge Nodes of a Binary Tree
    Print all edge nodes of a complete binary tree anti-clockwise.
    That is all the left most nodes starting at root, then the leaves left to right and finally all the rightmost nodes. In other words, print the boundary of the tree.
    Variant: Print the same for a tree that is not complete.
    http://www.leetcode.com/2010/10/print-edge-nodes-boundary-of-binary.html
 */

package question4_29;

import CtCILibrary.TreeNode;

public class Question {

    public static void printLeftEdge(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            return;
        }

        System.out.println(root.data);
        if(root.left!=null){
            printLeftEdge(root.left);
        } else if(root.right!=null){
            printLeftEdge(root.right);
        }
    }

    public static void printBottomEdge(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            System.out.println(root.data);
        } else {
            if(root.left!=null){
                printBottomEdge(root.left);
            }
            if(root.right!=null){
                printBottomEdge(root.right);
            }
        }
    }

    public static void printRightEdge(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            return;
        }
        if(root.right!=null){
            printRightEdge(root.right);
        } else if(root.left!=null){
            printRightEdge(root.left);
        }
        System.out.println(root.data);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        printLeftEdge(root);
        printBottomEdge(root);
        printRightEdge(root);
    }
}
