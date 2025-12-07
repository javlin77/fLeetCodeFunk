class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] red = new ArrayList[n];
        List<Integer>[] blue = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            red[i] = new ArrayList<>();
            blue[i] = new ArrayList<>();
        }
        for (int[] e : redEdges) red[e[0]].add(e[1]);
        for (int[] e : blueEdges) blue[e[0]].add(e[1]);

        int[][] dist = new int[n][2];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        // Start with no previous edge color → both red-start and blue-start allowed
        dist[0][0] = dist[0][1] = 0;
        q.add(new int[]{0, 0}); // last color = red (just symbolic)
        q.add(new int[]{0, 1}); // last color = blue

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int color = cur[1];

            if (color == 0) {
                // last was red, now we must use blue edges
                for (int nei : blue[node]) {
                    if (dist[nei][1] > dist[node][0] + 1) {
                        dist[nei][1] = dist[node][0] + 1;
                        q.add(new int[]{nei, 1});
                    }
                }
            } else {
                // last was blue, now use red edges
                for (int nei : red[node]) {
                    if (dist[nei][0] > dist[node][1] + 1) {
                        dist[nei][0] = dist[node][1] + 1;
                        q.add(new int[]{nei, 0});
                    }
                }
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.min(dist[i][0], dist[i][1]);
            if (ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        }
        return ans;
    }
}
