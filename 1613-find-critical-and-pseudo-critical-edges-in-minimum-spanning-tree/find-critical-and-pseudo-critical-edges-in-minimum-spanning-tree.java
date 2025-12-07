import java.util.*;

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] ext = new int[m][4];
        for (int i = 0; i < m; i++) {
            ext[i][0] = edges[i][0];
            ext[i][1] = edges[i][1];
            ext[i][2] = edges[i][2];
            ext[i][3] = i; // original index
        }

        Arrays.sort(ext, (a, b) -> Integer.compare(a[2], b[2]));

        int base = mst(n, ext, -1, -1);  // normal MST

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            // 1) check critical: skip this edge
            int wSkip = mst(n, ext, i, -1);
            if (wSkip > base) {
                critical.add(ext[i][3]);
            } else {
                // 2) check pseudo-critical: force include this edge
                int wForce = mst(n, ext, -1, i);
                if (wForce == base) {
                    pseudo.add(ext[i][3]);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(critical);
        ans.add(pseudo);
        return ans;
    }

    // Kruskal MST:
    // skipIdx: edge index in ext[] to ignore  (or -1)
    // forceIdx: edge index in ext[] to take first (or -1)
    private int mst(int n, int[][] ext, int skipIdx, int forceIdx) {
        DSU dsu = new DSU(n);
        int cost = 0;
        int edgesUsed = 0;

        if (forceIdx != -1) {
            int[] e = ext[forceIdx];
            if (dsu.union(e[0], e[1])) {
                cost += e[2];
                edgesUsed++;
            }
        }

        for (int i = 0; i < ext.length; i++) {
            if (i == skipIdx || i == forceIdx) continue;
            int[] e = ext[i];
            if (dsu.union(e[0], e[1])) {
                cost += e[2];
                edgesUsed++;
                if (edgesUsed == n - 1) break;
            }
        }

        if (edgesUsed != n - 1) return Integer.MAX_VALUE; // disconnected
        return cost;
    }

    static class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false;
            if (rank[ra] < rank[rb]) parent[ra] = rb;
            else if (rank[ra] > rank[rb]) parent[rb] = ra;
            else {
                parent[rb] = ra;
                rank[ra]++;
            }
            return true;
        }
    }
}
