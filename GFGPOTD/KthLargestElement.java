// k largest elements
// Difficulty: MediumAccuracy: 53.56%Submissions: 177K+Points: 4
// Given an array arr[] of positive integers and an integer k, Your task is to return k largest elements in decreasing order. 

// Examples:

// Input: arr[] = [12, 5, 787, 1, 23], k = 2
// Output: [787, 23]
// Explanation: 1st largest element in the array is 787 and second largest is 23.
// Input: arr[] = [1, 23, 12, 9, 30, 2, 50], k = 3 
// Output: [50, 30, 23]
// Explanation: Three Largest elements in the array are 50, 30 and 23 a.
// Input: arr[] = [12, 23], k = 1
// Output: [23]    
// Explanation: 1st Largest element in the array is 23.

Soln:

class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> pq =  new PriorityQueue<>((a,b)->b-a);
        for(int a:arr){
            pq.add(a);
        }
        ArrayList<Integer> lst=new ArrayList<>();
        while(k>0){
            lst.add(pq.poll());
            k--;
        }
        return lst;
    }
}
