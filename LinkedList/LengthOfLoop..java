


// Function should return the length of the loop in LL.

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // Add your code here.
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = fast.next;
                int count = 1;
                while(fast != slow){
                    count++;
                    fast = fast.next;
                }
                return count;
            }
        }
        return 0;
    }
}
