# A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:

# It is ().
# It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
# It can be written as (A), where A is a valid parentheses string.
# You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked,

# If locked[i] is '1', you cannot change s[i].
# But if locked[i] is '0', you can change s[i] to either '(' or ')'.
# Return true if you can make s a valid parentheses string. Otherwise, return false.

Soln:

class Solution(object):
    def canBeValid(self, s, locked):
        """
        :type s: str
        :type locked: str
        :rtype: bool
        """
        n = len(s)
        if n % 2 != 0:
            return False

        # Forward check (left to right)
        balance = 0
        for i in range(n):
            if s[i] == '(' or locked[i] == '0':
                balance += 1
            else:
                balance -= 1
            if balance < 0:
                return False

        # Backward check (right to left)
        balance = 0
        for i in range(n - 1, -1, -1):
            if s[i] == ')' or locked[i] == '0':
                balance += 1
            else:
                balance -= 1
            if balance < 0:
                return False

        return True
