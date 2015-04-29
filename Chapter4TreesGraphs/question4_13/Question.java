/**
    4.13    Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
    (CareerCups150 - 4.3)
    
    (CleanCodeHandbook--29)
    (leetcode108)
    (leetcodecpp5.3.4)
    http://articles.leetcode.com/2010/11/convert-sorted-array-into-balanced.html
 */
package question4_13;

import CtCILibrary.TreeNode;

public class Question {

    public static TreeNode sortedArrayToBST(int[] arr, int start, int end) {
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid-1);
        node.right = sortedArrayToBST(arr, mid+1, end);
        return node;
    }
    
    
    public static void main(String[] args) {

    }

}
