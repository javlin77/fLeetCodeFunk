class Solution {
public:
    double myPow(double x, int n) { 
        return func(x, (long)n); 
        }
public:
    double func(double x, long n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 1.0 / func(x, -n);
        if (n % 2 == 1)
            return x * func(x * x, (n - 1) / 2);
        else
            return func(x * x, n / 2);
    }
};