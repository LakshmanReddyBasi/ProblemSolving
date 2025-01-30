// Implement Pow
// Difficulty: MediumAccuracy: 52.79%Submissions: 28K+Points: 4
// Implement the function power(b, e), which calculates b raised to the power of e (i.e. be).

// Examples:

// Input: b = 3.00000, e = 5
// Output: 243.00000
// Input: b = 0.55000, e = 3
// Output: 0.16638
// Input: b = -0.67000, e = -7
// Output: -16.49971

SOln:

class Solution {
    double power(double b, int e) {
        if (e == 0) return 1.0;
        
        double result = 1.0;
        long exponent = e;
        
        if (exponent < 0) {
            b = 1 / b;
            exponent = -exponent;
        }

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= b;
            }
            b *= b;
            exponent >>= 1;
        }
        
        return result;
    }
}
