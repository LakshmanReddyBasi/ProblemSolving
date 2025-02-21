// Parenthesis Checker
// Difficulty: EasyAccuracy: 28.56%Submissions: 645K+Points: 2
// Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
// An input string is valid if:

//          1. Open brackets must be closed by the same type of brackets.
//          2. Open brackets must be closed in the correct order.

// Examples :

// Input: s = "[{()}]"
// Output: true
// Explanation: All the brackets are well-formed.
// Input: s = "[()()]{}"
// Output: true
// Explanation: All the brackets are well-formed.
// Input: s = "([]"
// Output: False
// Explanation: The expression is not balanced as there is a missing ')' at the end.
// Input: s = "([{]})"
// Output: False
// Explanation: The expression is not balanced as there is a closing ']' before the closing '}'.

Soln:

class Solution {
    static boolean isBalanced(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {      
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i)); 
            } 
            else {
                if (!st.empty() && 
                    ((st.peek() == '(' && s.charAt(i) == ')') ||
                     (st.peek() == '{' && s.charAt(i) == '}') ||
                     (st.peek() == '[' && s.charAt(i) == ']'))) {
                    st.pop(); 
                }
                else {    
                    return false; 
                }
            }
        }
        return st.empty();
    }
}
