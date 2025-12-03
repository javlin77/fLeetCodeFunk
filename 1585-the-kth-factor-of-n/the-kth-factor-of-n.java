class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) return i; 
                if (n/i != i) {
                    l.add(n / i);
                }
            }
        }
        if (k <= l.size()) {
            return l.get(l.size() - k);
        }
        return -1;
    }
}
