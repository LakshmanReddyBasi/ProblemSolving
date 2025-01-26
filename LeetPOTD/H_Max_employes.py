# 2127. Maximum Employees to Be Invited to a Meeting
# Solved
# Hard
# Topics
# Companies
# Hint
# A company is organizing a meeting and has a list of n employees, waiting to be invited. They have arranged for a large circular table, capable of seating any number of employees.

# The employees are numbered from 0 to n - 1. Each employee has a favorite person and they will attend the meeting only if they can sit next to their favorite person at the table. The favorite person of an employee is not themself.

# Given a 0-indexed integer array favorite, where favorite[i] denotes the favorite person of the ith employee, return the maximum number of employees that can be invited to the meeting.

 

# Example 1:


# Input: favorite = [2,2,1,2]
# Output: 3
# Explanation:
# The above figure shows how the company can invite employees 0, 1, and 2, and seat them at the round table.
# All employees cannot be invited because employee 2 cannot sit beside employees 0, 1, and 3, simultaneously.
# Note that the company can also invite employees 1, 2, and 3, and give them their desired seats.
# The maximum number of employees that can be invited to the meeting is 3. 
# Example 2:

# Input: favorite = [1,2,0]
# Output: 3
# Explanation: 
# Each employee is the favorite person of at least one other employee, and the only way the company can invite them is if they invite every employee.
# The seating arrangement will be the same as that in the figure given in example 1:
# - Employee 0 will sit between employees 2 and 1.
# - Employee 1 will sit between employees 0 and 2.
# - Employee 2 will sit between employees 1 and 0.
# The maximum number of employees that can be invited to the meeting is 3.
# Example 3:


# Input: favorite = [3,0,1,4,1]
# Output: 4
# Explanation:
# The above figure shows how the company will invite employees 0, 1, 3, and 4, and seat them at the round table.
# Employee 2 cannot be invited because the two spots next to their favorite employee 1 are taken.
# So the company leaves them out of the meeting.
# The maximum number of employees that can be invited to the meeting is 4.
 

Soln:

class Solution:
    def maximumInvitations(self, favorite: List[int]) -> int:
        n = len(favorite)
        levels = [1]*n
        indegree = [0]*n
        
        for i in range(n):
            indegree[favorite[i]] += 1
        
        queue = deque()
        for i in range(n):
            if indegree[i] == 0:
                queue.append(i)

        while queue:
            node = queue.popleft()
            neighbor = favorite[node]
            indegree[neighbor] -= 1
            levels[neighbor] = levels[node]+1 
            if indegree[neighbor] == 0:
                queue.append(neighbor)
        
        longest_path = max_perimeter = 0
        for i in range(n):
            if indegree[i] != 0:
                circle_start = circle_node = i
                indegree[circle_node] -= 1
                circle_perimeter = 1
                while favorite[circle_node]!=circle_start:
                    circle_node = favorite[circle_node]
                    indegree[circle_node] -= 1
                    circle_perimeter += 1

                if circle_perimeter == 2:
                    longest_path += levels[circle_start] + levels[circle_node]
                else:
                    max_perimeter = max(max_perimeter, circle_perimeter)                    
        return max(max_perimeter, longest_path)



                            (OR)

  from collections import deque

class Solution(object):
    def maximumInvitations(self, favorite):
        n = len(favorite)
        in_deg = [0] * n
        chain_len = [0] * n
        visited = [False] * n
        q = deque()
        
        for f in favorite:
            in_deg[f] += 1
        
        for i in range(n):
            if in_deg[i] == 0:
                q.append(i)
        
        while q:
            u = q.popleft()
            visited[u] = True
            v = favorite[u]
            chain_len[v] = max(chain_len[v], chain_len[u] + 1)
            in_deg[v] -= 1
            if in_deg[v] == 0:
                q.append(v)
        
        max_cycle, pair_chains = 0, 0
        
        for i in range(n):
            if visited[i]:
                continue
            cycle_len = 0
            current = i
            while not visited[current]:
                visited[current] = True
                current = favorite[current]
                cycle_len += 1
            if cycle_len == 2:
                pair_chains += 2 + chain_len[i] + chain_len[favorite[i]]
            else:
                max_cycle = max(max_cycle, cycle_len)
        
        return max(max_cycle, pair_chains)
