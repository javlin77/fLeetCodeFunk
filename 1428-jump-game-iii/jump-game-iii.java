class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n];
        q.offer(start);
        v[start] = true;
        while (!q.isEmpty()) {
            int i = q.poll();
            if (arr[i] == 0) {
                return true;
            }
            int f = i + arr[i];
            int b = i - arr[i];
            if (f < n && !v[f]) {
                v[f] = true;
                q.offer(f);
            }
            if (b >= 0 && !v[b]) {
                v[b] = true;
                q.offer(b);
            }
        }
        return false;
    }
}