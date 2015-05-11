/**
    4.33    Populating next Right Pointers in Each Node
    Given a binary tree
    struct TreeLinkNode {
                TreeLinkNode *left;
                TreeLinkNode *right;
                TreeLinkNode *next;
    }
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
    Initially, all next pointers are set to NULL.
    Note:
    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
    For example,
    Given the following perfect binary tree,

    After calling your function, the tree should look like:

    (leetcode116)
    (leetcodecpp5.4.6)
    http://articles.leetcode.com/2010/03/first-on-site-technical-interview.html

    Follow up for problem "Populating Next Right Pointers in Each Node".
    What if the given tree could be any binary tree? Would your previous solution still work?
    Note:
    You may only use constant extra space.
    For example,
    Given the following binary tree,

    After calling your function, the tree should look like:


    (leetcode117)
    (leetcodecpp5.1.12)
 */
package question4_33;

import java.util.ArrayList;
import java.util.List;

public class Question {

    class TreeLinkNode {
        public TreeLinkNode left;
        public TreeLinkNode right;
        public TreeLinkNode next;
        public int val;

        public TreeLinkNode(int val){
            this.val = val;
            this.next = null;
        }
    }


    public static void populatePerfectBT(TreeLinkNode root){
        if(root==null){
            return;
        }
        root.left.next = root.right;
        if(root.next!=null){
            root.right.next = root.next.left;
        }
        populatePerfectBT(root.left);
        populatePerfectBT(root.right);
    }

    public static void populateNonPerfectBT(TreeLinkNode root){
        List<TreeLinkNode> currentList = new ArrayList<Question.TreeLinkNode>();
        currentList.add(root);
        while(!currentList.isEmpty()){
            List<TreeLinkNode> newList = new ArrayList<Question.TreeLinkNode>();
            for(TreeLinkNode node : currentList){
                if(node.left!=null){
                    if(newList.size()>0){
                        newList.get(newList.size()-1).next = node.left;
                    }
                    newList.add(node.left);
                }
                if(node.right!=null){
                    if(newList.size()>0){
                        newList.get(newList.size()-1).next = node.right;
                    }
                    newList.add(node.right);
                }
            }
            currentList = newList;
        }
    }


    public static void main(String[] args) {

    }

}
