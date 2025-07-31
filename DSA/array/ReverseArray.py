# You are given an array of integers arr[]. You have to reverse the given array.

# Note: Modify the array in place.

# Examples:

# Input: arr = [1, 4, 3, 2, 6, 5]
# Output: [5, 6, 2, 3, 4, 1]
# Explanation: The elements of the array are [1, 4, 3, 2, 6, 5]. After reversing the array, the first element goes to the last position, the second element goes to the second last position and so on. Hence, the answer is [5, 6, 2, 3, 4, 1].
# Input: arr = [4, 5, 2]
# Output: [2, 5, 4]
# Explanation: The elements of the array are [4, 5, 2]. The reversed array will be [2, 5, 4].
# Input: arr = [1]
# Output: [1]
# Explanation: The array has only single element, hence the reversed array is same as the original.

Soln:
class Solution:
    def reverseArray(self, arr):
        # code here
        n=len(arr)
        i=0

        while(i<n//2):
            temp=arr[n-i-1]
            arr[n-i-1]=arr[i]
            arr[i]=temp
            i+=1
        return arr

_________________________________________________

2 pointers:

class Solution:
    def reverseArray(self, arr):
        left, right = 0, len(arr) - 1
        while left < right:
            arr[left], arr[right] = arr[right], arr[left]
            left += 1
            right -= 1
        return arr

        
        
        

