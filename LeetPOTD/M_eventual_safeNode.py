# 802. Find Eventual Safe States
# Solved
# Medium
# Topics
# Companies
# There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

# A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

# Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

 

# # a
# Illustration of graph
# Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
# Output: [2,4,5,6]
# Explanation: The given graph is shown above.
# Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
# Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
# Example 2:

# Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
# Output: [4]
# Explanation:
# Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.


Soln:
class Solution:
    def eventualSafeNodes(self, graph):
        n = len(graph)
        state = [0] * n  # 0: unvisited, 1: visiting, 2: safe
        safe = []

        def dfs(node):
            if state[node] > 0:
                return state[node] == 2  # Return true if already safe
            
            state[node] = 1  # Mark as visiting
            
            for neighbor in graph[node]:
                if state[neighbor] == 1 or not dfs(neighbor):
                    return False  # Cycle detected
            
            state[node] = 2  # Mark as safe
            return True
        
        for i in range(n):
            if dfs(i):
                safe.append(i)
        
        return safe
