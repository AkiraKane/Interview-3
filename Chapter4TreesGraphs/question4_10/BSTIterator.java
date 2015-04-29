package question4_10;

import java.util.Iterator;
import java.util.Stack;

import CtCILibrary.TreeNode;

public class BSTIterator implements Iterator<TreeNode>{

    private Stack<TreeNode> store;
    
    public BSTIterator(TreeNode root){
        store = new Stack<TreeNode>();
        store.add(root);
        goToNextNode();
    }
    
    @Override
    public boolean hasNext() {
        return !store.isEmpty();
    }
    
    @Override
    public TreeNode next() {
        if(!store.isEmpty()){
            TreeNode oldNextNode = store.peek();
            if(oldNextNode!=null){
                goToNextNode();
            }
            return oldNextNode;
        }
        return null;
    }

    // this is the real function
    private void goToNextNode() {
        if(!store.isEmpty()){
            TreeNode runner = store.pop();
            if(runner.right!=null){
                runner=runner.right;
                while(runner.left!=null){
                    store.push(runner);
                    runner=runner.left;
                }
            } else {
                TreeNode parent = store.peek();
                while(parent!=null && parent.left!=runner){
                    runner = store.pop();
                    parent = store.peek();
                }
            }
        }
    }

    @Override
    public void remove() {
        // not implemented for this question
    }


}
