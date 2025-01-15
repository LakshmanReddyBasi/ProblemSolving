# 2429. Minimize XOR
# Given two positive integers num1 and num2, find the positive integer x such that:

# x has the same number of set bits as num2, and
# The value x XOR num1 is minimal.
# Note that XOR is the bitwise XOR operation.

# Return the integer x. The test cases are generated such that x is uniquely determined.

# The number of set bits of an integer is the number of 1's in its binary representation.

 

# Example 1:

# Input: num1 = 3, num2 = 5
# Output: 3
# Explanation:
# The binary representations of num1 and num2 are 0011 and 0101, respectively.
# The integer 3 has the same number of set bits as num2, and the value 3 XOR 3 = 0 is minimal.
# Example 2:

# Input: num1 = 1, num2 = 12
# Output: 3
# Explanation:
# The binary representations of num1 and num2 are 0001 and 1100, respectively.
# The integer 3 has the same number of set bits as num2, and the value 3 XOR 1 = 2 is minimal.

Soln:

class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        bits1 = bin(num1).count("1")
        bits2 = bin(num2).count("1")

        if bits1 == bits2:
            return num1
        
        if bits1 > bits2:
            r = num1
            remove = bits1 - bits2
            x = 1
            while remove > 0:
                if r & x > 0:
                    r ^= x
                    remove -= 1
                x <<= 1
            return r
        
        if bits1 < bits2:
            r = num1
            add = bits2 - bits1
            x = 1
            while add > 0:
                if r & x == 0:
                    r |= x
                    add -= 1
                x <<= 1
            return r


--------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        (or)

class Solution(object):
    def minimizeXor(self, num1, num2):
        a, b = bin(num1).count('1'), bin(num2).count('1')
        res = num1
        for i in range(32):
            if a > b and (1 << i) & num1 > 0:
                res ^= 1 << i
                a -= 1
            if a < b and (1 << i) & num1 == 0:
                res ^= 1 << i
                a += 1
        return res
