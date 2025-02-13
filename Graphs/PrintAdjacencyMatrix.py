# Print adjacency list
# Difficulty: EasyAccuracy: 43.42%Submissions: 157K+Points: 2
# Given an undirected graph with V nodes and E edges, create and return an adjacency list of the graph. 0-based indexing is followed everywhere.

# Example 1:

# Input:
# V = 5, E = 7
# edges = [[0,1], [0,4], [4,1], [4,3], [1,3], [1,2], [3,2]]

# Output: 
# [[1,4], [0,2,3,4], [1,3], [1,2,4], [0,1,3]]
# Explanation:
# Node 0 is connected to 1 and 4.
# Node 1 is connected to 0,2,3 and 4.
# Node 2 is connected to 1 and 3.
# Node 3 is connected to 1,2 and 4.
# Node 4 is connected to 0,1 and 3.

Soln:

from typing import List


class Solution:
    def printGraph(self, V : int, edges : List[List[int]]) -> List[List[int]]:
        # code here
        res = [[] for _ in range(V)]
        for edge in edges:
            u, v = edge
            res[u].append(v)
            res[v].append(u)
        
        return res

_______________________________________________________________________________________

Java:

class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<V;i++){
            res.add(new ArrayList<>());
        }
        for (int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            res.get(u).add(v);
            res.get(v).add(u);
        }
        return res;
    }
}
