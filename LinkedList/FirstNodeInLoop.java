// Problem statement
// You are given a singly linked list that may or may not contain a cycle. You are supposed to return the node where the cycle begins, if a cycle exists, else return 'NULL'.
// A cycle occurs when a node's next pointer returns to a previous node in the list.
// Example:
// In the given linked list, there is a cycle starting at position 0, hence we return 0.

public class Solution {
    public static Node firstNode(Node head) {
        // Write your code here.
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow ){
                slow = head;
                while(fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
