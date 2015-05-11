/**
    4.22    You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum up to that value. Note that a path can start or end anywhere in the tree.
    (CareerCups150 -- 4.9)
 */

package question4_22;

import java.util.ArrayList;
import java.util.List;

import CtCILibrary.TreeNode;


public class Question {

    public static void findSum(TreeNode node, int sum){
        List<Integer> path = new ArrayList<Integer>();
        findSum(node, sum, path, 0);
    }

    public static void findSum(TreeNode node, int sum, List<Integer> path, int level){
        if(node==null){
            return;
        }
        path.add(node.data);

        int t=0;
        for(int i=level; i>=0; i--){
            t+=path.get(i);
            if(t==sum){
                print(path, i, level);
            }
        }

        List<Integer> newPathLeft = new ArrayList<Integer>();
        List<Integer> newPathRight = new ArrayList<Integer>();
        newPathLeft.addAll(path);
        newPathRight.addAll(path);
        findSum(node.left, sum, newPathLeft, level+1);
        findSum(node.right, sum, newPathRight, level+1);
    }

    public static void print(List<Integer> path, int start, int end){
        for(int i=start; i<=end; i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(6);
        findSum(root, 8);
    }


}
