// Search in a row-wise sorted matrix
// Difficulty: EasyAccuracy: 51.77%Submissions: 16K+Points: 2
// Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x, find whether element x is present in the matrix.
// Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. for any i, j within bounds, mat[i][j] <= mat[i][j+1].

// Examples :

// Input: mat[][] = [[3, 4, 9],[2, 5, 6],[9, 25, 27]], x = 9
// Output: true
// Explanation: 9 is present in the matrix, so the output is true.
// Input: mat[][] = [[19, 22, 27, 38, 55, 67]], x = 56
// Output: false
// Explanation: 56 is not present in the matrix, so the output is false.
// Input: mat[][] = [[1, 2, 9],[65, 69, 75]], x = 91
// Output: false
// Explanation: 91 is not present in the matrix.
// Constraints:
// 1 <= n, m <= 1000
// 1 <= mat[i][j] <= 105
// 1 <= x <= 105

// APPROACH
//   Iterate through each row of the matrix, as the rows are sorted, and perform a binary search on each row.
//   If the element is found in any row, return true; otherwise, return false after checking all rows.

class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        int n = mat.length;
        for(int i = 0 ; i < n; i++){
            int low = 0,high=mat[i].length-1;
            while(low<=high){
                int mid = (low+high)/2;
                if (mat[i][mid]==x)
                    return true;
                else if(mat[i][mid]<x)
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return false;
         
    }
}

                    (or)

public boolean searchRowMatrix(int[][] mat, int x) {
    for (int[] row : mat) if (binarySearch(row, x)) return true; 
    return false;
}

private boolean binarySearch(int[] row, int x) {
    int low = 0, high = row.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (row[mid] == x) return true;
        if (row[mid] < x) low = mid + 1;
        else high = mid - 1;
    }
    return false;
}
