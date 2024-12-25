// Problem statement
// You are given a Singly Linked List of integers. Return true if it has a cycle, else return false.
// A cycle occurs when a node's next points back to a previous node in the list.
// Example:
// In the given linked list, there is a cycle, hence we return true



// We can Hashmap for bruteforce Approach
// Optimal Approach
public class Solution {
    public static boolean detectCycle(Node head) {
        //Your code goes here
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next ;
            if(fast == slow )
                return true;
        }
        return false;
    }
}
