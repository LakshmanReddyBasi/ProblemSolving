// Given the head of a singly linked list, return true if it is a 
// palindrome
//  or false otherwise.


  /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverseLL(slow);
        ListNode first = head;
        ListNode second = newHead;
        boolean isPalindrome = true;
        while (second != null) {
            if (first.val != second.val) {
                isPalindrome = false;
                break;
            }
            first = first.next;
            second = second.next;
        }
        reverseLL(newHead);

        return isPalindrome;
    }

    public ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseLL(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
