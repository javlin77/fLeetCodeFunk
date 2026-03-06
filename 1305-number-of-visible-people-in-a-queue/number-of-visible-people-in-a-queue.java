class Solution {
        public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stk.isEmpty() && heights[stk.peek()] < heights[i]) {
                ++ans[stk.pop()];
            }
            if (!stk.isEmpty()) {
                ++ans[stk.peek()];
            }
            stk.push(i);
        }
        return ans;
    }
}