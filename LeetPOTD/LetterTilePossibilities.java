// You have n  tiles, where each tile has one letter tiles[i] printed on it.

// Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

// Example 1:

// Input: tiles = "AAB"
// Output: 8
// Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
// Example 2:

// Input: tiles = "AAABBC"
// Output: 188
// Example 3:

// Input: tiles = "V"
// Output: 1
 


Soln:

class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        backtrack(tiles, "", set, used);
        return set.size();
    }

    private void backtrack(String tiles, String current, HashSet<String> set, boolean[] used) {
        if (!current.isEmpty()) {
            set.add(current);
        }

        for (int i = 0; i < tiles.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(tiles, current + tiles.charAt(i), set, used);
                used[i] = false;
            }
        }
    }
}



python:

class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        a=set()
        for i in range(1,len(tiles)+1):
            for p in permutations(tiles,i):
                a.add(p)
        return len(a)

        
