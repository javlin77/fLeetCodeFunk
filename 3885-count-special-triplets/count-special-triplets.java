class Solution {
    public int specialTriplets(int[] nums) {
        final int MOD = 1000000007;
        Map<Integer, Integer> c = new HashMap<>();
        Map<Integer, Integer> partialc = new HashMap<>();
        for (int v : nums) {
            c.put(v, c.getOrDefault(v, 0) + 1);
        }
        long ans = 0;
        for (int v : nums) {
            int target = v * 2;
            int l = partialc.getOrDefault(target, 0);
            partialc.put(v, partialc.getOrDefault(v, 0) + 1);
            int r =
                c.getOrDefault(target, 0) -
                partialc.getOrDefault(target, 0);
            ans = (ans + (long) l * r) % MOD;
        }
        return (int) ans;
    }
}