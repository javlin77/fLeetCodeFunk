class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, int[]> r = new HashMap<>();
        HashMap<Integer, int[]> c = new HashMap<>();
        for (int[] i : buildings) {
            int x = i[0];
            int y = i[1];
            r.putIfAbsent(y, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            c.putIfAbsent(x, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            int[] row = r.get(y);
            row[0] = Math.min(row[0], x);
            row[1] = Math.max(row[1], x);
            int[] col = c.get(x);
            col[0] = Math.min(col[0], y);
            col[1] = Math.max(col[1], y);
        }
        int count = 0;
        for (int[] i : buildings) {
            int x = i[0];
            int y = i[1];
            int[] row = r.get(y);
            int[] col = c.get(x);
            if (x > row[0] && x < row[1] && y > col[0] && y < col[1]) {
                count++;
            }
        }
        return count;
    }
}
