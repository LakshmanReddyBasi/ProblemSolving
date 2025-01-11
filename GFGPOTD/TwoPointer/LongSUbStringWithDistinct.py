
# Given a string s, find the length of the longest substring with all distinct characters. 

# Examples:

# Input: s = "geeksforgeeks"
# Output: 7
# Explanation: "eksforg" is the longest substring with all distinct characters.
# Input: s = "aaa"
# Output: 1
# Explanation: "a" is the longest substring with all distinct characters.
# Input: s = "abcdefabcbb"
# Output: 6
# Explanation: The longest substring with all distinct characters is "abcdef", which has a length of 6.

Soln:

class Solution:
    def longestUniqueSubstr(self, s):
        # Initialize variables
        max_len = 0
        start = 0
        char_index = {}

        for end in range(len(s)):
            if s[end] in char_index:
                start = max(start, char_index[s[end]] + 1)
            
            char_index[s[end]] = end

            max_len = max(max_len, end - start + 1)

        return max_len




          (or)

---------------------------------------------------------------------------------------------------------------

# Python code to find the largest substring with non-repeating
# characters using Sliding Window

MAX_CHAR = 26

def longestUniqueSubstr(s):
    if len(s) == 0 or len(s) == 1:
        return len(s)

    res = 0
    vis = [False] * MAX_CHAR

    # left and right pointer of sliding window
    left = 0
    right = 0
    while right < len(s):

        # If character is repeated, move left pointer marking
        # visited characters as false until the repeating 
        # character is no longer part of the current window
        while vis[ord(s[right]) - ord('a')] == True:
            vis[ord(s[left]) - ord('a')] = False
            left += 1

        vis[ord(s[right]) - ord('a')] = True

        # The length of the current window (right - left + 1)
        # is calculated and answer is updated accordingly.
        res = max(res, (right - left + 1))
        right += 1

    return res

if __name__ == "__main__":
    s = "geeksforgeeks"
    print(longestUniqueSubstr(s))
