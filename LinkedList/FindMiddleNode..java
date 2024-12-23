// Problem statement
// Given a singly linked list of 'N' nodes. The objective is to determine the middle node of a singly linked list. However, if the list has an even number of nodes, we return the second middle node.

// Note:
// 1. If the list is empty, the function immediately returns None because there is no middle node to find.
// 2. If the list has only one node, then the only node in the list is trivially the middle node, and the function returns that node.

public class Solution
{
    public static Node findMiddle(Node head)
    {
        // Write your code here.
        if(head == null) return null;
        if(head.next == null) return head;
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if( fast.next!=null){
                fast = fast.next;
            }
        }
        return slow;
    }
}
