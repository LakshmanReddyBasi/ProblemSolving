// Product array puzzle
// Difficulty: EasyAccuracy: 33.46%Submissions: 266K+Points: 2
// Given an array, arr[] construct a product array, res[] where each element in res[i] is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].
// Note: Each element is res[] lies inside the 32-bit integer range.

// Examples:

// Input: arr[] = [10, 3, 5, 6, 2]
// Output: [180, 600, 360, 300, 900]
// Explanation: For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
// For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
// For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
// For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
// For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.
// Input: arr[] = [12, 0]
// Output: [0, 12]
// Explanation: For i = 0, res[i] is 0.
// For i = 1, res[i] is 12.

Soln:

class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here'
        int prod = 1;
        int n=arr.length;
        int[] res=new int[n];
        int zeroes=0;
        for(int ele : arr){
            if(ele!=0)
                prod*=ele;
            else zeroes++;
        }
        
        if(zeroes>1){
            Arrays.fill(res,0);
        }
        if(zeroes==1){
            for (int i=0;i<n;i++){
                if(arr[i]==0)
                    res[i]=prod;
                else
                    res[i]=0;
            }
        }  
        if(zeroes==0){
            for (int i=0;i<n;i++)
                res[i]=prod/arr[i];
        }
        return res;
    }
}



            (OR)

        

import java.util.Arrays;

class GfG {
  
    // Function to calculate the product of all
    // elements except the current element
    static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] prefProduct = new int[n];
        int[] suffProduct = new int[n];
        int[] res = new int[n];

        // Construct the prefProduct array
        prefProduct[0] = 1;
        for (int i = 1; i < n; i++)
            prefProduct[i] = arr[i - 1] * prefProduct[i - 1];

        // Construct the suffProduct array
        suffProduct[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--)
            suffProduct[j] = arr[j + 1] * suffProduct[j + 1];

        // Construct the result array using
        // prefProduct[] and suffProduct[]
        for (int i = 0; i < n; i++)
            res[i] = prefProduct[i] * suffProduct[i];

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 2};
        int[] res = productExceptSelf(arr);

        System.out.println(Arrays.toString(res));
    }
}
