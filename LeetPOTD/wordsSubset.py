# You are given two string arrays words1 and words2.

# A string b is a subset of string a if every letter in b occurs in a including multiplicity.

# For example, "wrr" is a subset of "warrior" but is not a subset of "world".
# A string a from words1 is universal if for every string b in words2, b is a subset of a.

# Return an array of all the universal strings in words1. You may return the answer in any order.

 

# Example 1:

# Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
# Output: ["facebook","google","leetcode"]
# Example 2:

# Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
# Output: ["apple","google","leetcode"]

Soln:

class Solution(object):
    def wordSubsets(self, words1, words2):
        """
        :type words1: List[str]
        :type words2: List[str]
        :rtype: List[str]
        """
        def merge_max_counts(count1, count2):
            for char, count in count2.items():
                count1[char] = max(count1.get(char, 0), count)
            return count1

        max_count = Counter()
        for word in words2:
            max_count = merge_max_counts(max_count, Counter(word))
        
        universal_words = []
        for word in words1:
            word_count = Counter(word)
            if all(word_count[char] >= max_count[char] for char in max_count):
                universal_words.append(word)
        
        return universal_words

        
