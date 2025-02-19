// Merge K sorted linked lists
// Difficulty: MediumAccuracy: 57.01%Submissions: 97K+Points: 4Average Time: 60m
// Given an array arr[] of n sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list, then return the head of the merged linked list.

// Examples:

// Input: arr[] = [1 -> 2 -> 3, 4 -> 5, 5 -> 6, 7 -> 8]
// Output: 1 -> 2 -> 3 -> 4 -> 5 -> 5 -> 6 -> 7 -> 8
// Explanation:
// The arr[] has 4 sorted linked list of size 3, 2, 2, 2.
// 1st list: 1 -> 2-> 3
// 2nd list: 4 -> 5
// 3rd list: 5 -> 6
// 4th list: 7 -> 8
// The merged list will be:
 
// Input: arr[] = [1 -> 3, 8, 4 -> 5 -> 6]
// Output: 1 -> 3 -> 4 -> 5 -> 6 -> 8
// Explanation:
// The arr[] has 3 sorted linked list of size 2, 3, 1.
// 1st list: 1 -> 3
// 2nd list: 8
// 3rd list: 4 -> 5 -> 6
// The merged list will be:
// Merge K sorted linked lists
// Difficulty: MediumAccuracy: 57.01%Submissions: 97K+Points: 4Average Time: 60m
// Given an array arr[] of n sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list, then return the head of the merged linked list.

// Examples:

// Input: arr[] = [1 -> 2 -> 3, 4 -> 5, 5 -> 6, 7 -> 8]
// Output: 1 -> 2 -> 3 -> 4 -> 5 -> 5 -> 6 -> 7 -> 8
// Explanation:
// The arr[] has 4 sorted linked list of size 3, 2, 2, 2.
// 1st list: 1 -> 2-> 
// 2nd list: 4 -> 5
// 3rd list: 5 -> 6
// 4th list: 7 -> 8
// The merged list will be:
 
// Input: arr[] = [1 -> 3, 8, 4 -> 5 -> 6]
// Output: 1 -> 3 -> 4 -> 5 -> 6 -> 8
// Explanation:
// The arr[] has 3 sorted linked list of size 2, 3, 1.
// 1st list: 1 -> 3
// 2nd list: 8
// 3rd list: 4 -> 5 -> 6
// The merged list will be:


Soln:

class Solution {
    // Function to merge K sorted linked list.

    static Node getMinNode(List<Node> arr) {
        Node mini = null;
        int index = -1;
        
        for (int i = 0; i < arr.size(); i++) {
            
            // If current list is processed
            if (arr.get(i) == null) continue;
            
            // If min node is not set or 
            // current head has smaller value.
            if (mini == null || arr.get(i).data < mini.data) {
                index = i;
                mini = arr.get(i);
            }
        }
        
        // Increment the head node 
        if (index != -1) arr.set(index, arr.get(index).next);
        
        return mini;
    }
    
    // Function to merge K sorted linked lists
    Node mergeKLists(List<Node> arr) {
        // Add your code here.

        Node dummy = new Node(-1);
        Node tail = dummy;
    
        Node mini = getMinNode(arr);
        
        // Process all nodes.
        while (mini != null) {
            
            // Append min node to the result.
            tail.next = mini;
            tail = mini;
            
            // Find the next min node 
            mini = getMinNode(arr);
        }
    
        return dummy.next;
    }
}
