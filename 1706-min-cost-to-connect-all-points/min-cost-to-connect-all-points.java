import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] inMST = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;

            // pick closest non-MST vertex
            for (int v = 0; v < n; v++) {
                if (!inMST[v] && (u == -1 || dist[v] < dist[u])) {
                    u = v;
                }
            }

            inMST[u] = true;
            total += dist[u];

            // relax distances using u
            for (int v = 0; v < n; v++) {
                if (!inMST[v]) {
                    int w = Math.abs(points[u][0] - points[v][0])
                          + Math.abs(points[u][1] - points[v][1]);
                    if (w < dist[v]) dist[v] = w;
                }
            }
        }

        return total;
    }
}
