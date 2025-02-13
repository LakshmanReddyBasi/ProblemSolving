# Graph and Vertices
# Difficulty: EasyAccuracy: 59.13%Submissions: 38K+Points: 2Average Time: 15m
# Given an integer n representing number of vertices. Find out how many undirected graphs (not necessarily connected) can be constructed out of a given n number of vertices.

 

# Example 1:

# Input: 2
# Output: 2
# Example 2:

# Input: 5
# Output: 1024

Soln:

class Solution:
    def count(self, n):
        # Code here
        total_edges=n*(n-1)//2
        return 2**total_edges
