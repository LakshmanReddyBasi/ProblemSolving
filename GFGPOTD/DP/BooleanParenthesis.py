
























# Problems Solved

# 22 of 22 Complete. (100%)

# Progress may take upto 2 hours to reflect.

# Boolean Parenthesization
# Difficulty: HardAccuracy: 20.15%Submissions: 133K+Points: 8Average Time: 30m
# You are given a boolean expression s containing
#     'T' ---> true
#     'F' ---> false 
# and following operators between symbols
#    &   ---> boolean AND
#     |   ---> boolean OR
#    ^   ---> boolean XOR
# Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

# Note: The answer is guaranteed to fit within a 32-bit integer.

# Examples:

# Input: s = "T|T&F^T"
# Output: 4
# Explaination: The expression evaluates to true in 4 ways: ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
# Input: s = "T^F|F"
# Output: 2
# Explaination: The expression evaluates to true in 2 ways: ((T^F)|F) and (T^(F|F)).

soln:

#User function Template for python3
class Solution:

        
    def countWays(self,s):
        n = len(s)
        dp = [[[0, 0] for _ in range(n)] for _ in range(n)]
    
        for i in range(0, n, 2):
            dp[i][i][1] = 1 if s[i] == 'T' else 0
            dp[i][i][0] = 1 if s[i] == 'F' else 0
    
        for length in range(2, n, 2): 
            for i in range(0, n - length, 2):
                j = i + length
                dp[i][j][0] = dp[i][j][1] = 0
    
                for k in range(i + 1, j, 2):
                    op = s[k]
                    leftTrue, leftFalse = dp[i][k - 1][1], dp[i][k - 1][0]
                    rightTrue, rightFalse = dp[k + 1][j][1], dp[k + 1][j][0]
    
                    if evaluate(1, 1, op):
                        dp[i][j][1] += leftTrue * rightTrue
                    if evaluate(1, 0, op):
                        dp[i][j][1] += leftTrue * rightFalse
                    if evaluate(0, 1, op):
                        dp[i][j][1] += leftFalse * rightTrue
                    if evaluate(0, 0, op):
                        dp[i][j][1] += leftFalse * rightFalse
                    if not evaluate(1, 1, op):
                        dp[i][j][0] += leftTrue * rightTrue
                    if not evaluate(1, 0, op):
                        dp[i][j][0] += leftTrue * rightFalse
                    if not evaluate(0, 1, op):
                        dp[i][j][0] += leftFalse * rightTrue
                    if not evaluate(0, 0, op):
                        dp[i][j][0] += leftFalse * rightFalse
    
        return dp[0][n - 1][1] 

def evaluate(b1, b2, op):
    if op == '&':
        return b1 & b2
    if op == '|':
        return b1 | b2
    return b1 ^ b2
