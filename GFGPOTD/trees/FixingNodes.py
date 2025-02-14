# Fixing Two nodes of a BST
# Difficulty: HardAccuracy: 53.68%Submissions: 63K+Points: 8Average Time: 45m
# Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
# Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original Binary search tree(BST).
 
# Examples :
# Input: root = [10, 5, 8, 2, 20]
     
# Output: 1
       

# Explanation: The nodes 20 and 8 were swapped. 
# Input: root = [5, 10, 20, 2, 8]
     
# Output: 1 
     
# Explanation: The nodes 10 and 5 were swapped.

Soln:
class  Solution:
    def correctBST(self, root):
        def correctBSTUtil(root, first, middle, last, prev):
            if root is None:
                return
            
            correctBSTUtil(root.left, first, middle, last, prev)
            
            if prev[0] and root.data < prev[0].data:
                if not first[0]:
                    first[0] = prev[0]
                    middle[0] = root
                else:
                    last[0] = root
            
            prev[0] = root
            correctBSTUtil(root.right, first, middle, last, prev)

        first, middle, last, prev = [None], [None], [None], [None]
        correctBSTUtil(root, first, middle, last, prev)
        
        if first[0] and last[0]:
            first[0].data, last[0].data = last[0].data, first[0].data
        elif first[0] and middle[0]:
            first[0].data, middle[0].data = middle[0].data, first[0].data

