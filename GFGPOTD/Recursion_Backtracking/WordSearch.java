// Word Search
// Difficulty: MediumAccuracy: 32.69%Submissions: 62K+Points: 4
// You are given a two-dimensional mat[][] of size n*m containing English alphabets and a string word. Check if the word exists on the mat. The word can be constructed by using letters from adjacent cells, either horizontally or vertically. The same cell cannot be used more than once.

// Examples :

// Input: mat[][] = [['T', 'E', 'E'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
// Output: true
// Explanation:

// The letter cells which are used to construct the "GEEK" are colored.
// Input: mat[][] = [['T', 'E', 'U'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
// Output: false
// Explanation:

// It is impossible to construct the string word from the mat using each cell only once.
// Input: mat[][] = [['A', 'B', 'A'], ['B', 'A', 'B']], word = "AB"
// Output: true
// Explanation:

// There are multiple ways to construct the word "AB".

Soln:
class Solution {

    static boolean findMatch(char[][] mat, String word, int x, int y, 
                                                           int wIdx) {
        int wLen = word.length();
        int n = mat.length;
        int m = mat[0].length;

        // Pattern matched
        if (wIdx == wLen)
            return true;

        // Out of Boundary
        if (x < 0 || y < 0 || x >= n || y >= m)
            return false;

        if (mat[x][y] == word.charAt(wIdx)) {
            // Marking this cell as visited
            char temp = mat[x][y];
            mat[x][y] = '#';

            // finding subpattern in 4 directions
            boolean res = findMatch(mat, word, x - 1, y, wIdx + 1) ||
                          findMatch(mat, word, x + 1, y, wIdx + 1) ||
                          findMatch(mat, word, x, y - 1, wIdx + 1) ||
                          findMatch(mat, word, x, y + 1, wIdx + 1);

            mat[x][y] = temp;
            return res;
        }

        return false;
    }

    static boolean isWordExist(char[][] mat, String word) {
        int wLen = word.length();
        int n = mat.length;
        int m = mat[0].length;

        if (wLen > n * m)
            return false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (mat[i][j] == word.charAt(0)) {
                    if (findMatch(mat, word, i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }    
}
