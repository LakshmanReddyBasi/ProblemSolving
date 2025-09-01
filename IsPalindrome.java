// You are given a string s. Your task is to determine if the string is a palindrome. A string is considered a palindrome if it reads the same forwards and backwards.

// Examples :

// Input: s = "abba"
// Output: true
// Explanation: "abba" reads the same forwards and backwards, so it is a palindrome.
// Input: s = "abc" 
// Output: false
// Explanation: "abc" does not read the same forwards and backwards, so it is not a palindrome.

Soln:

class Solution {
    boolean isPalindrome(String s) {
        // code here
        StringBuilder ss=new StringBuilder(s);
        return (ss.reverse().toString().equals(s));
    }
}

-------------------------------------------------------

  class Solution {
    boolean isPalindrome(String s) {
        // code here
        // StringBuilder ss=new StringBuilder(s);
        // return (ss.reverse().toString().equals(s));
        int left=0, right=s.length()-1;
        while (left<right){
            if (s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
            
        }
        return true;
    }
}
