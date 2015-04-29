/**
    4.4     Check if a tree is BST.
    (CareerCups150 -- 4.5)
    
    Validate Binary search tree
    (CleanCodeHandbook--25)
    (leetcode98)
    (leetcodecpp5.3.3)
    http://articles.leetcode.com/2010/09/determine-if-binary-tree-is-binary.html
 */
package question4_4;

import CtCILibrary.TreeNode;

public class Question {

    public static boolean checkBSTMethodA(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.left!=null && root.data<root.left.data){
            return false;
        }
        if(root.right!=null && root.data>root.right.data){
            return false;
        }
        return checkBSTMethodA(root.left) && checkBSTMethodA(root.right);
    }

    
    public static boolean checkBSTMethodB(TreeNode root){
        
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6, 10, 13, 15, 100};
        TreeNode root = TreeNode.createMinimalBST(array);
        
        root.print();
        boolean isBST = checkBSTMethodA(root);
        System.out.println(isBST);
    
    }

}
