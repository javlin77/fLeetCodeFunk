class Solution {
    public int totalMoney(int n) {
        int res = 0;
        int c = n / 7;
        int a = 28;
        if (c == 0) {
            return n * (n + 1) / 2;
        }
        for (int i = 1; i < c; i++) {
            a += (28 + 7 * i);
        }
        int rem = n % 7;
        res = a + rem * (2 * c + rem + 1) / 2;
        return res;
    }
}