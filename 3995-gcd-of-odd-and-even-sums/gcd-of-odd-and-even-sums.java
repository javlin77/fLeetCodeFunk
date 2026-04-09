class Solution {
    public int gcdOfOddEvenSums(int n) {
        int o=n*n;
        int e=o+n;
        return gcd(o,e);
    }
    public int gcd(int a,int b){
        if (b == 0) {
            return a;
        }
        return gcd(b,a%b);
    }
}