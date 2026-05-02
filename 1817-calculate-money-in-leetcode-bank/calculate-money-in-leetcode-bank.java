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
        res = a + (n % 7) * ((n % 7) + 1) / 2 + (n % 7) * c;
        return res;
    }
}