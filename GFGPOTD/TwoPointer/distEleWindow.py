# Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

Soln:

class Solution:
    def countDistinct(self, arr, k):
        # Code here
        n=len(arr)
        result=[]
        for i in range(n-k+1):
            result.append(len(set(arr[i:i+k])))
        return result

        (or)


-----------------------------------------------------------------------------------------------------------------
  from collections import defaultdict

# Function to count distinct elements in every window of size k
def countDistinct(arr, k):
    n = len(arr)  
    res = []
    freq = defaultdict(int)
  
    # Store the frequency of elements of the first window
    for i in range(k):
        freq[arr[i]] += 1
  
    # Store the count of distinct elements of the first window
    res.append(len(freq))
  
    for i in range(k, n):
        freq[arr[i]] += 1
        freq[arr[i - k]] -= 1
      
        # If the frequency of arr[i - k] becomes 0, remove it from the hash map
        if freq[arr[i - k]] == 0:
            del freq[arr[i - k]]
      
        res.append(len(freq))
      
    return res
