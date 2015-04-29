/**
    4.12    Find the nth smallest element in a binary search tree (BST).
    if the size of the tree is unknown.
    if the size of the tree is known.
    
    Get the nth largest node in BST.
    http://stackoverflow.com/questions/2612362/nth-largest-element-in-a-binary-search-tree
 */
package question4_12;

import java.util.ArrayList;
import java.util.List;

import CtCILibrary.TreeNode;

public class Question {

    public static TreeNode findNthSmallestNode(TreeNode root, int n, List<TreeNode> store){
        if(root==null){
            return null;
        }
        
        TreeNode leftNode = findNthSmallestNode(root.left, n, store);
        if(leftNode!=null){
            return leftNode;
        }
        
        store.add(root);
        if(store.size()==n){
            return root;
        }
        TreeNode rightNode = findNthSmallestNode(root.right, n, store);
        if(rightNode!=null){
            return rightNode;
        }
        
        return null;
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode node = findNthSmallestNode(root, 4, new ArrayList<TreeNode>());
        System.out.println(node.data);
    }

}
