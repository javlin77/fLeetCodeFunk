class Solution {
    public boolean isGood(int[] nums){
        int n = nums.length;
        int[] count = new int[n];
        for (int i : nums) {
            if (i >= n) {
                return false;
            }
            if (i < n - 1 && count[i] > 0) {
                return false;
            }
            if (i == n - 1 && count[i] > 1) {
                return false;
            }
            count[i]++;
        }
        return true;
    }
}