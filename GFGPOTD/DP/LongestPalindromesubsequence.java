// Longest Palindromic Subsequence
// Difficulty: MediumAccuracy: 56.57%Submissions: 101K+Points: 4
// Given a string s, return the length of the longest palindromic subsequence.

// A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.

// A palindromic sequence is a sequence that reads the same forward and backward.

// Examples:

// Input: s = "bbabcbcab"
// Output: 7
// Explanation: Subsequence "babcbab" is the longest subsequence which is also a palindrome.
// Input: s = "abcd"


// Output: 1
// Explanation: "a", "b", "c" and "d" are palindromic and all have a length 1.
// Input: s = "agbdba"
// Output: 5
// Explanation: The longest palindromic subsequence is "abdba", which has a length of 5. The characters in this subsequence are taken from the original string "agbdba", and they maintain the order of the string while forming a palindrome.

SOln:
Using MEmoization:

  
class Solution {
    public static int lps(String s, int low, int high, int[][] memo) {

        if (low > high) return 0;

        if (low == high)
            return 1;

        if (memo[low][high] != -1) 
            return memo[low][high];

        if (s.charAt(low) == s.charAt(high))
            return memo[low][high] = 
                    lps(s, low + 1, high - 1, memo) + 2;
        return memo[low][high] = 
                Math.max(lps(s, low, high - 1, memo), 
                         lps(s, low + 1, high, memo));
    }

    static int longestPalinSubseq(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return lps(s, 0, n - 1, memo);
    }

}
