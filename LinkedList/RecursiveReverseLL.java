// Problem statement
// You are given a Singly Linked List of integers. You need to reverse the Linked List by changing the links between nodes.

// Note :
// You do not need to print anything, just return the head of the reversed linked list

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

// recursive

public class Solution
{
    public static Node reverseLinkedList(Node head)
    {
        // Write your code here.
        if(head==null || head.next ==null) return head;
        Node newHead = reverseLinkedList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;

    }
}
