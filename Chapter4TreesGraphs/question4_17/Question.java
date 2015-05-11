/**
    4.17    You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
    Create an algorithm to decide if T2 is a subtree of T1.
    A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.
    (CareerCups150 -- 4.8)
 */

package question4_17;

import CtCILibrary.TreeNode;

public class Question {

    public static boolean containsTree(TreeNode t1, TreeNode t2){
        if(t2==null){
            return true;
        }
        return subTree(t1, t2);
    }

    public static boolean subTree(TreeNode r1, TreeNode r2){
        if(r1==null){
            return false;
        }
        if(r1.data == r2.data){
            return matchTree(r1, r2);
        }
        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }

    public static boolean matchTree(TreeNode r1, TreeNode r2){
        if(r2==null && r1==null){
            return true;
        }
        if(r1==null || r2==null){
            return false;
        }
        if(r1.data!=r2.data){
            return false;
        }
        return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
    }


    public static void main(String[] args) {

    }

}
