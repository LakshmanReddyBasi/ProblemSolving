// BFS of graph
// Difficulty: EasyAccuracy: 44.09%Submissions: 455K+Points: 2Average Time: 10m
// Given a undirected graph represented by an adjacency list adj, which is a vector of vectors where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Traversal (BFS) starting from vertex 0, visiting vertices from left to right according to the adjacency list, and return a list containing the BFS traversal of the graph.

// Note: Do traverse in the same order as they are in the adjacency list.

// Examples:

// Input: adj = [[2,3,1], [0], [0,4], [0], [2]]

// Output: [0, 2, 3, 1, 4]
// Explanation: Starting from 0, the BFS traversal will follow these steps: 
// Visit 0 → Output: 0 
// Visit 2 (first neighbor of 0) → Output: 0, 2 
// Visit 3 (next neighbor of 0) → Output: 0, 2, 3 
// Visit 1 (next neighbor of 0) → Output: 0, 2, 3, 
// Visit 4 (neighbor of 2) → Final Output: 0, 2, 3, 1, 4
// Input: adj = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]

// Output: [0, 1, 2, 3, 4]
// Explanation: Starting from 0, the BFS traversal proceeds as follows: 
// Visit 0 → Output: 0 
// Visit 1 (the first neighbor of 0) → Output: 0, 1 
// Visit 2 (the next neighbor of 0) → Output: 0, 1, 2 
// Visit 3 (the first neighbor of 2 that hasn't been visited yet) → Output: 0, 1, 2, 3 
// Visit 4 (the next neighbor of 2) → Final Output: 0, 1, 2, 3, 4
// Input: adj = [[1], [0, 2, 3], [1], [1, 4], [3]]
// Output: [0, 1, 2, 3, 4]
// Explanation: Starting the BFS from vertex 0:
// Visit vertex 0 → Output: [0]
// Visit vertex 1 (first neighbor of 0) → Output: [0, 1]
// Visit vertex 2 (first unvisited neighbor of 1) → Output: [0, 1, 2]
// Visit vertex 3 (next neighbor of 1) → Output: [0, 1, 2, 3]
// Visit vertex 4 (neighbor of 3) → Final Output: [0, 1, 2, 3, 4]
// Constraints:

Soln:

class Solution{
      public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            visited[i] = 0;
        }
        q.offer(0);
        visited[0] = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            for (int neighbour : adj.get(curr)) {
                if (visited[neighbour] == 0) {
                    q.add(neighbour);
                    visited[neighbour] = 1;
                }
            }
        }
        return res;
    }
}
