class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] maxr = new int[n + 1];
        int[] minr = new int[n + 1];
        int[] maxc = new int[n + 1];
        int[] minc = new int[n + 1];
        Arrays.fill(minr, n + 1);
        Arrays.fill(minc, n + 1);
        for (int[] i : buildings) {
            int x = i[0];
            int y = i[1];
            maxr[y] = Math.max(maxr[y], x);
            minr[y] = Math.min(minr[y], x);
            maxc[x] = Math.max(maxc[x], y);
            minc[x] = Math.min(minc[x], y);
        }
        int count = 0;
        for (int[] i : buildings) {
            int x = i[0];
            int y = i[1];
            if (x > minr[y] && x < maxr[y] && y > minc[x] && y < maxc[x]) {
                count++;
            }
        }
        return count;
    }
}