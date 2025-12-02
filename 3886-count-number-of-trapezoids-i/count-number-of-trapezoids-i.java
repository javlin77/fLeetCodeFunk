class Solution {

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> m = new HashMap<>();
        final int mod = 1000000007;
        long ans = 0;
        long sum = 0;
        for (int[] p : points) {
            m.put(p[1], m.getOrDefault(p[1], 0) + 1);
        }
        for (int i : m.values()) {
            long edge = ((long) i * (i - 1)) / 2;
            ans = (ans + edge * sum) % mod;
            sum = (sum + edge) % mod;
        }
        return (int) ans;
    }
}