/**
    2.18    Copy list with Random Pointer
    A linked list is given such that each node contains an additional random pointer that could point to any node in the list or null.
    Return a deep copy of the list.
    (CleanCodeHandbook--24)
    (leetcode138)
    (leetcodecpp2.2.10)
 */
package question2_18;

import java.util.HashMap;

public class Question {

    class RandomListNode {
        public String label;
        public RandomListNode next;
        public RandomListNode random;
        
        public RandomListNode() {
        }
        
        public RandomListNode(String label) {
            this.label = label;
        }
    }
    
    // Using Hashmap
    // O(n) runtime, O(n) space
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = head;
        RandomListNode dummy = new RandomListNode();
        RandomListNode q = dummy;
        while (p != null) {
           q.next = new RandomListNode(p.label);
           map.put(p, q.next);
           p = p.next;
           q = q.next;
        }
        p = head;
        q = dummy;
        while (p != null) {
           q.next.random = map.get(p.random);
           p = p.next;
           q = q.next;
     }
        return dummy.next;
     }
    
    public RandomListNode copyRandomList2(RandomListNode head){
        RandomListNode p = head;
        while (p != null) {
           RandomListNode next = p.next;
           RandomListNode copy = new RandomListNode(p.label);
           p.next = copy;
           copy.next = next;
           p = next;
        }
        p = head;
        while (p != null) {
           p.next.random = (p.random != null) ? p.random.next : null;
           p = p.next.next;
        }
        p = head;
        RandomListNode headCopy = (p != null) ? p.next : null;
        while (p != null) {
           RandomListNode copy = p.next;
           p.next = copy.next;
           p = p.next;
           copy.next = (p != null) ? p.next : null;
        }
        return headCopy;
    }
    
    public static void main(String[] args) {
        
    }

}
