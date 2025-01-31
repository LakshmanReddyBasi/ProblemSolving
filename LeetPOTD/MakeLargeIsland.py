

# 827. Making A Large Island
# Hard
# Topics
# Companies
# You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

# Return the size of the largest island in grid after applying this operation.

# An island is a 4-directionally connected group of 1s.

 

# Example 1:

# Input: grid = [[1,0],[0,1]]
# Output: 3
# Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
# Example 2:

# Input: grid = [[1,1],[1,0]]
# Output: 4
# Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
# Example 3:

# Input: grid = [[1,1],[1,1]]
# Output: 4
# Explanation: Can't change any 0 to 1, only one island with area = 4.
 

Soln:

class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)
        id = 2
        sz = {}

        def dfs(row, col, isl_id):
            grid[row][col] = isl_id
            size = 1

            if row != 0:
                if grid[row - 1][col] == 1:
                    size += dfs(row - 1, col, isl_id)
            if col != 0:
                if grid[row][col - 1] == 1:
                    size += dfs(row, col - 1, isl_id)
            if row != n - 1:
                if grid[row + 1][col] == 1:
                    size += dfs(row + 1, col, isl_id)
            if col != n - 1:
                if grid[row][col + 1] == 1:
                    size += dfs(row, col + 1, isl_id)
            
            return size
        
        for i in range(n):
            for j in range(n):
                ts = 0
                if grid[i][j] == 1:
                    ts = dfs(i, j, id)
                    sz[id] = ts
                    id += 1
        
        if not sz:
            return 1
        
        res = max(sz.values())

        for i in range(n):
            for j in range(n):
                
                if grid[i][j] == 0:
                    sn = set()
                    p = 1

                    if i != 0:
                        if grid[i - 1][j] > 1:
                            t = grid[i - 1][j]
                            if t not in sn:
                                p += sz[t]
                                sn.add(t)
                    
                    if i != n - 1:
                        if grid[i + 1][j] > 1:
                            t = grid[i + 1][j]
                            if t not in sn:
                                p += sz[t]
                                sn.add(t)
                    
                    if j != 0:
                        if grid[i][j - 1] > 1:
                            t = grid[i][j - 1]
                            if t not in sn:
                                p += sz[t]
                                sn.add(t)
                    
                    if j != n - 1:
                        if grid[i][j + 1] > 1:
                            t = grid[i][j + 1]
                            if t not in sn:
                                p += sz[t]
                                sn.add(t)
                    
                    res = max(res, p)
        return res



                                (OR)
    ------------------------------------------------------------------------------------------------------------

class Solution(object):
    def largestIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        n = len(grid)
        directions = [ (1,0), (-1,0), (0,1), (0,-1) ]
        key = []
        current_id = 2

        def dfs(i, j, id):
            if i < 0 or j < 0 or i >= n or j >= n or grid[i][j] != 1:
                return 0
            grid[i][j] = id
            count = 1
            for dx, dy in directions:
                count += dfs(i + dx, j + dy, id)
            return count

        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    size = dfs(i, j, current_id)
                    key.append(size)
                    current_id += 1

        if not key:
            return 1

        max_size = 0

        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    seen = set()
                    current = 1
                    for dx, dy in directions:
                        ni, nj = i + dx, j + dy
                        if 0 <= ni < n and 0 <= nj < n and grid[ni][nj] != 0:
                            island_id = grid[ni][nj]
                            if island_id not in seen:
                                current += key[island_id - 2]
                                seen.add(island_id)
                    max_size = max(max_size, current)

        return max_size if max_size != 0 else n * n
