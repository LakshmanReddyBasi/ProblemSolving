# Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

# Example 1:

# Input: s = "anagram", t = "nagaram"

# Output: true

# Example 2:

# Input: s = "rat", t = "car"

# Output: false

 

# Constraints:

# 1 <= s.length, t.length <= 5 * 104
# s and t consist of lowercase English letters.

Soln:

#Hash Map
class Solution(object):
    def isAnagram(self, s, t):

        count = {}
        
        for ch in s:
            count[ch] = count.get(ch, 0) + 1
        
        for ch in t:
            if ch not in count:
                return False
            count[ch] -= 1
            if count[ch] == 0:
                del count[ch]
        
        return len(count) == 0



____________________________________________________________________________


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        a=Counter(s)
        b=Counter(t)
        return a==b        
