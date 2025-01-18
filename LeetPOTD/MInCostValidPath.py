1368. Minimum Cost to Make at Least One Valid Path in a Grid
Hard
Topics
Companies
Hint
Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:

1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
Notice that there could be some signs on the cells of the grid that point outside the grid.

You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path does not have to be the shortest.

You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

Return the minimum cost to make the grid have at least one valid path.

 

Example 1:


Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
Output: 3
Explanation: You will start at point (0, 0).
The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)
The total cost = 3.
Example 2:


Input: grid = [[1,1,3],[3,2,2],[1,1,4]]
Output: 0
Explanation: You can follow the path from (0, 0) to (2, 2).
Example 3:


Input: grid = [[1,2],[4,3]]
Output: 1


SolN:

def minCost(self, grid: List[List[int]]) -> int:
   m, n = len(grid), len(grid[0])
   directions = [(0,1), (0,-1), (1,0), (-1,0)]
   dist = [[float('inf')] * n for _ in range(m)]
   dist[0][0] = 0
   from collections import deque
   dq = deque([(0, 0, 0)])
   
   while dq:
       cost, row, col = dq.popleft()
       if cost > dist[row][col]:
           continue
           
       for i, (dr, dc) in enumerate(directions):
           new_row, new_col = row + dr, col + dc
           if 0 <= new_row < m and 0 <= new_col < n:
               new_cost = cost + (0 if grid[row][col] == i + 1 else 1)
               if new_cost < dist[new_row][new_col]:
                   dist[new_row][new_col] = new_cost
                   if grid[row][col] == i + 1:
                       dq.appendleft((new_cost, new_row, new_col))
                   else:
                       dq.append((new_cost, new_row, new_col))
   
   return dist[m-1][n-1]




                          (OR)




class Solution:
  def minCost(self, grid: list[list[int]]) -> int:
    m = len(grid)
    n = len(grid[0])
    dirs = ((0, 1), (0, -1), (1, 0), (-1, 0))
    dp = [[-1] * n for _ in range(m)]
    q = collections.deque()

    def dfs(i: int, j: int, cost: int) -> None:
      if i < 0 or i == m or j < 0 or j == n:
        return
      if dp[i][j] != -1:
        return

      dp[i][j] = cost
      q.append((i, j))
      dx, dy = dirs[grid[i][j] - 1]
      dfs(i + dx, j + dy, cost)

    dfs(0, 0, 0)

    cost = 0
    while q:
      cost += 1
      for _ in range(len(q)):
        i, j = q.popleft()
        for dx, dy in dirs:
          dfs(i + dx, j + dy, cost)

    return dp[-1][-1]
