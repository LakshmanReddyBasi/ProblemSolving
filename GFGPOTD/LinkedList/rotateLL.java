// Given the head of a singly linked list, your task is to left rotate the linked list k times.

// Examples:

// Input: head = 10 -> 20 -> 30 -> 40 -> 50, k = 4
// Output: 50 -> 10 -> 20 -> 30 -> 40
// Explanation:
// Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
// Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
// Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
// Rotate 4: 50 -> 10 -> 20 -> 30 -> 40

Soln:

class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        if(head==null || head.next==null || k==0){
            return head;
        }
        Node curr = head;
        int length = 1;
        while(curr.next!=null){
            length++;
            curr=curr.next;
        }
        k=k%length;
        if(k==0){
            return head;
        }
        int i=1;
        curr=head;
        while(i<k){
            curr=curr.next;
            i++;
        }
        Node newhead=curr.next;
        curr.next=null;
        curr=newhead;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=head;

        return newhead;
        
    }
}
