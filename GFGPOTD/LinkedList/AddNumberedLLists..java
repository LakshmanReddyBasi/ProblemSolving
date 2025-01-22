// Add Number Linked Lists
// Difficulty: MediumAccuracy: 34.52%Submissions: 311K+Points: 4
// Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

// For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

// Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

// Examples:

// Input: num1 = 4 - > 5, num2 = 3 -> 4 -> 5
// Output:  3 -> 9 -> 0
 
// Explanation: Given numbers are 45 and 345. There sum is 390.
// Input: num1 = 0 -> 0 -> 6 -> 3, num2 = 0 -> 7 
// Output: 7 -> 0 
 
// Explanation: Given numbers are 63 and 7. There sum is 70.

SOln:

class Solution {
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    // Function to trim leading zeros in linked list
    static Node trimLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }

    // Function to add two numbers represented by linked list
    static Node addTwoLists(Node num1, Node num2) {
        Node res = null;
        Node curr = null;
        int carry = 0;
      
        num1 = trimLeadingZeros(num1);
        num2 = trimLeadingZeros(num2);
      
        num1 = reverse(num1);
        num2 = reverse(num2);

        // Iterate till either num1 is not empty or num2 is
        // not empty or carry is greater than 0
        while (num1 != null || num2 != null || carry != 0) {
            int sum = carry;

            // If num1 linked list is not empty, add it to sum
            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }

            // If num2 linked list is not empty, add it to sum
            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }
          
            // Create a new node with sum % 10 as its value
            Node newNode = new Node(sum % 10);

            // Store the carry for the next nodes
            carry = sum / 10;

            // If this is the first node, then make this node
            // as the head of the resultant linked list
            if (res == null) {
                res = newNode;
                curr = newNode;
            } else {
                // Append new node to resultant linked list
                // and move to the next node
                curr.next = newNode;
                curr = curr.next;
            }
        }

        // Reverse the resultant linked list to get the
        // required linked list
        return reverse(res);
    }
}
