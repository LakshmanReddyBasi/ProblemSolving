# Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

# A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

# Example 1:

# Input: s = "abc", t = "ahbgdc"
# Output: true
# Example 2:

# Input: s = "axc", t = "ahbgdc"
# Output: false

class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        n = len(s)
        m = len(t)
        return self.recursive(s, t, n, m)

    def recursive(self, s, t, n, m):
        # If s is empty, it's a subsequence of any string
        if n == 0:
            return True
        # If t is empty but s is not, then s can't be a subsequence
        if m == 0:
            return False
        # If last characters match, move both pointers
        if s[n-1] == t[m-1]:
            return self.recursive(s, t, n-1, m-1)
        else:
            # Otherwise, only move t's pointer
            return self.recursive(s, t, n, m-1)
