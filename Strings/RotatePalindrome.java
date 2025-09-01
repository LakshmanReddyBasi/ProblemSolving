class Solution {
    int isRotatedPalindrome(String s) {
        // Your Code Here
        int n =s.length();

        s=s+s;
        for (int i=0;i<n;i++){
            if (isPalindrome(s.substring(i,i+n))) return 1;
        }
        return 0;
    }
    boolean isPalindrome(String str){
        int left=0, right=str.length()-1;
        while (left<right){
            if (str.charAt(left)!=str.charAt(right)) return false;
            left++;
            right--;
            
        }
        return true;
    }
}
