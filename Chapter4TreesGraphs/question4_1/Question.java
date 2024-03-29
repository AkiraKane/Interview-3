/**
    4.1     Breadth First Search
    (CareerCups150 - P85)
     
    4.1.1   Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
    For example:
    Given binary tree {3,9,20,#,#,15,7},
    
    return its level order traversal as:
    
    (leetcode102)
    (leetcode5.1.4)
    http://articles.leetcode.com/2010/09/printing-binary-tree-in-level-order.html
     
    Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth (eg, if you have a tree with depth D, you’ll have D linked lists)    
    (CareerCups150 -- 4.4)
     
    4.1.2   Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
    For example:
    Given binary tree {3,9,20,#,#,15,7},
    
    return its bottom-up level order traversal as:
    
    (leetcode107)
    (leetcodecpp5.1.5)
     
    4.1.3   Binary Tree Zigzag Level Order Traversal
    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
    For example:
    Given binary tree {3,9,20,#,#,15,7},
    
    return its zigzag level order traversal as:
    
    
    (leetcode103)
    (leetcodecpp5.1.6)
    http://articles.leetcode.com/2010/09/printing-binary-tree-in-zig-zag-level_18.html
 */

package question4_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

public class Question {
    
    // top->down traversal
    public static ArrayList<LinkedList<TreeNode>> topToBottomTraversal(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        
        // root
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if(root!=null){
            current.add(root);
        }
        
        while(current.size()>0){
            result.add(current); // add previous level
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for(TreeNode parent : parents){
                if(parent.left!=null){
                    current.add(parent.left);
                }
                if(parent.right!=null){
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
    
    // down->top traversal
    public static ArrayList<LinkedList<TreeNode>> bottomToTopTraversal(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        
        // root
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if(root!=null){
            current.add(root);
        }
        
        while(current.size()>0){
            result.add(0, current); // add previous level
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for(TreeNode parent : parents){
                if(parent.left!=null){
                    current.add(parent.left);
                }
                if(parent.right!=null){
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
    
    // zig-zag traversal
    public static ArrayList<ArrayList<TreeNode>> zigzagTraversal(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
        
        // root
        ArrayList<TreeNode> current = new ArrayList<TreeNode>();
        if(root!=null){
            current.add(root);
        }
        
        int level = 0;
        while(current.size()>0){
            result.add(current); // add previous level
            ArrayList<TreeNode> parents = current;
            current = new ArrayList<TreeNode>();
            if(level%2==0){
                for(int i=parents.size()-1; i>=0; i--){
                    TreeNode parent = parents.get(i);
                    if(parent.right!=null){
                        current.add(parent.right);
                    }
                    if(parent.left!=null){
                        current.add(parent.left);
                    }
                }
            } else {
                for(int i=parents.size()-1; i>=0; i--){
                    TreeNode parent = parents.get(i);
                    if(parent.left!=null){
                        current.add(parent.left);
                    }
                    if(parent.right!=null){
                        current.add(parent.right);
                    }
                }
            }
            level++;
        }
        return result;
    }
   

    public static void printResult(ArrayList<LinkedList<TreeNode>> result){
        int depth = 0;
        for(LinkedList<TreeNode> entry : result){
            Iterator<TreeNode> i = entry.listIterator();
            System.out.print("Linked list at depth " + depth + ":");
            while(i.hasNext()){
                System.out.print(" "+ ((TreeNode)i.next()).data);
            }
            System.out.println();
            depth++;
        }
    }
    
    public static void printResult2(ArrayList<ArrayList<TreeNode>> result){
        int depth = 0;
        for(ArrayList<TreeNode> entry : result){
            Iterator<TreeNode> i = entry.listIterator();
            System.out.print("Linked list at depth " + depth + ":");
            while(i.hasNext()){
                System.out.print(" "+ ((TreeNode)i.next()).data);
            }
            System.out.println();
            depth++;
        }
    }
    

    public static void main(String[] args) {
        int[] nodes_flattened = {1,2,3,4,5,6,7,8,9,10};
        TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
        
        ArrayList<LinkedList<TreeNode>> list1 = topToBottomTraversal(root);
        printResult(list1);
        
        System.out.println();
        
        ArrayList<LinkedList<TreeNode>> list2 = bottomToTopTraversal(root);
        printResult(list2);
        
        System.out.println();
        
        ArrayList<ArrayList<TreeNode>> list3 = zigzagTraversal(root);
        printResult2(list3);
    }
}
