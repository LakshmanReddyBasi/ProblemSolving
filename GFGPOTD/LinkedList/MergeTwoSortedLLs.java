//  Given the head of two sorted linked lists consisting of nodes respectively.
// // The task is to merge both lists and return the head of the sorted merged list.

// Examples:

// Input: head1 = 5 -> 10 -> 15 -> 40, head2 = 2 -> 3 -> 20
// Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40

// Input: head1 = 1 -> 1, head2 = 2 -> 4
// Output: 1 -> 1 -> 2 -> 4

Soln:

Iterative:


class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        Node result;
        if (head1.data <= head2.data){
            result = head1;
            head1=head1.next;
        }
        else{
            result =head2;
            head2=head2.next;
        }
        Node node = result;
        while(head1!=null && head2!=null){
            if (head1.data <= head2.data){
                node.next=head1;
                node=node.next;
                head1=head1.next;
            }
            else{
                node.next=head2;
                node=node.next;
                head2=head2.next;
            } 
        }
        if (head1 != null) {
            node.next = head1;
        } else {
            node.next = head2;
        }
        return result;
    }
}


          (OR)

---------------------------------------------------------------

           
Recursive:

            
class Solution {
    Node sortedMerge(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node result;
        if (head1.data <= head2.data) {
            result = head1;
            result.next = sortedMerge(head1.next, head2);
        } else {
            result = head2;
            result.next = sortedMerge(head1, head2.next);
        }
        return result;
    }
}
