// Permutations of a String
// Difficulty: MediumAccuracy: 34.65%Submissions: 293K+Points: 4
// Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.

// Examples:

// Input: s = "ABC"
// Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
// Explanation: Given string ABC has 6 unique permutations.
// Input: s = "ABSG"
// Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
// Explanation: Given string ABSG has 24 unique permutations.
// Input: s = "AAA"
// Output: ["AAA"]
// Explanation: No other unique permutations can be formed as all the characters are same.

Soln:



class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        backtrack(sArray, result, 0);
        return result;
    }
    
    private void backtrack(char[] sArray, ArrayList<String> result, int index) {
        if (index == sArray.length) {
            result.add(new String(sArray));
            return;
        }
        
        Set<Character> seen = new HashSet<>();
        for (int i = index; i < sArray.length; i++) {
            if (seen.contains(sArray[i])) {
                continue;
            }
            seen.add(sArray[i]);
            swap(sArray, i, index);
            backtrack(sArray, result, index + 1);
            swap(sArray, i, index);
        }
    }
    
    private void swap(char[] sArray, int i, int j) {
        char temp = sArray[i];
        sArray[i] = sArray[j];
        sArray[j] = temp;
    }
}
