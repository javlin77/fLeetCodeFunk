class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] g = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int[] r : roads) {
            g[r[0]].add(new int[]{r[1], r[2]});
            g[r[1]].add(new int[]{r[0], r[2]});
        }

        boolean[] vis = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int[] nxt : g[u]) {
                ans = Math.min(ans, nxt[1]);
                int v = nxt[0];
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
        return ans;
    }
}
