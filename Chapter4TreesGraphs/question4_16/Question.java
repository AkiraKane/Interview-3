/**
    4.16    Binary tree lowest common ancestor
    Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing additional nodes in a data structure. Note: This is not necessarily a binary search tree.
    (CareerCups150 - 4.7)
    http://articles.leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-search-tree.html
    http://articles.leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-i.html
    http://articles.leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-ii.html
 */
package question4_16;

import CtCILibrary.TreeNode;

public class Question {

    public static TreeNode findCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(p==null || q==null){
            return null;
        }

        return null;
    }

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        boolean pOnLeft = covers(root.left, p);
        boolean qOnLeft = covers(root.left, q);
        if(pOnLeft!=qOnLeft){
            return root;
        }
        TreeNode child = pOnLeft ? root.left : root.right;
        return commonAncestor(child, p, q);
    }

    public static boolean covers(TreeNode root, TreeNode p){
        if(root==null){
            return false;
        }
        if(root==p){
            return true;
        }
        return covers(root.left, p)||covers(root.right, p);

    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n3 = root.find(3);
        TreeNode n7 = root.find(7);
        TreeNode ancestor = commonAncestor(root, n3, n7);
        System.out.println(ancestor.data);
    }
}
