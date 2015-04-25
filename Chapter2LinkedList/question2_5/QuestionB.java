/**
    FOLLOW UP
    Suppose the digits are stored in forward order. Repeat the above problem.
    EXAMPLE:
    Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).
    Output: 9 -> 1 ->2.  That is, 912.
    (CareerCups150 - 2.5)
 */

package question2_5;

import CtCILibrary.LinkedListNode;

public class QuestionB {

//    public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2){
//        
//        
//        
//        
//    }
    
    
    
    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(3, null, null);
        LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(5, null, lA2);
        
        LinkedListNode lB1 = new LinkedListNode(5, null, null);
        LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(1, null, lB2);  
        
//        LinkedListNode list3 = addLists(lA1, lB1);
//        
//        System.out.println("  " + lA1.printForward());      
//        System.out.println("+ " + lB1.printForward());          
//        System.out.println("= " + list3.printForward());    
    }

}
