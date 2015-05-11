/**
    4.21    Sum root to leaf numbers
    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
    An example is the root-to-leaf path 1->2->3 which represents the number 123.
    Find the total sum of all root-to-leaf numbers.
    For example,

    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Return the sum = 12 + 13 = 25.
    (leetcode129)
    (leetcodecpp5.4.7)
 */
package question4_21;

import java.util.ArrayList;
import java.util.List;

import CtCILibrary.TreeNode;

public class Question {

    public static int sumRootToLeaf(TreeNode root){
        List<String> paths = new ArrayList<String>();
        sumRootToLeaf(root, "", paths);

        // calculate the sum
        int sum = 0;
        for(String path : paths){
            sum+=Integer.valueOf(path);
        }
        return sum;
    }

    public static void sumRootToLeaf(TreeNode root, String path, List<String> paths){
        if(root==null){
            return;
        }
        path = path+root.data;
        if(root.left==null && root.right==null){
            paths.add(path);
        } else {
            if(root.left!=null){
                sumRootToLeaf(root.left, path, paths);
            }
            if(root.right!=null){
                sumRootToLeaf(root.right, path, paths);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumRootToLeaf(root));
    }

}
