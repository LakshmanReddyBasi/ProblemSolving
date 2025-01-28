// 2658. Maximum Number of Fish in a Grid
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:

// A land cell if grid[r][c] = 0, or
// A water cell containing grid[r][c] fish, if grid[r][c] > 0.
// A fisher can start at any water cell (r, c) and can do the following operations any number of times:

// Catch all the fish at cell (r, c), or
// Move to any adjacent water cell.
// Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.

// An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.

 

// Example 1:


// Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
// Output: 7
// Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move to cell (2,3) and collect 4 fish.
// Example 2:


// Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
// Output: 1
// Explanation: The fisher can start at cells (0,0) or (3,3) and collect a single fish. 
 

SOln:


// Intuition
// The problem seems to be about finding the maximum number of fish that can be caught from a connected area in a 2D grid. The intuition is to use a depth-first search (DFS) to explore connected cells with fish and sum up the total fish in each connected component.

// Approach
// Iterate through each cell in the grid.
// If a cell contains fish (value > 0), start a DFS from that cell.
// In the DFS:
// Mark the current cell as visited.
// Add the fish in the current cell to the total.
// Recursively explore the four adjacent cells (up, down, left, right).
// Return the total fish caught in this connected component.
// Keep track of the maximum fish caught among all connected components.

class Solution {
    
    public int findMaxFish(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int maxFish=0;       

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0) continue;    

                maxFish=Math.max(maxFish, dfs(grid, i, j, m, n));
            }
        }

        return maxFish;
    }

    int dfs(int[][] grid, int i, int j, int m, int n){        
        int fish=0;
        
        if( i<0 || i>=m || j<0 || j>=n || grid[i][j]==0) return fish;   
             
        fish+=grid[i][j];
        
        grid[i][j]=0; //Visited

                                           
        fish+=dfs(grid, i, j+1, m, n);
        fish+=dfs(grid, i, j-1, m, n);
        fish+=dfs(grid, i+1, j, m, n);
        fish+=dfs(grid, i-1, j, m, n);
        

        return fish;
    }

}
