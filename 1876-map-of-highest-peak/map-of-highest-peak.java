class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] ans = new int[m][n];
        for (int[] row : ans) Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();

        // Push all water cells with height 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (ans[nx][ny] != -1) continue; // already assigned

                ans[nx][ny] = ans[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        return ans;
    }
}
