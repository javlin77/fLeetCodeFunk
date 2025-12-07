class MyCalendarTwo {
    List<int[]> booked;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // check triple overlap
        for (int[] o : overlaps) {
            if (Math.max(o[0], start) < Math.min(o[1], end)) {
                return false;
            }
        }

        // update overlaps list from booked
        for (int[] b : booked) {
            int s = Math.max(b[0], start);
            int e = Math.min(b[1], end);
            if (s < e) {
                overlaps.add(new int[]{s, e});
            }
        }

        booked.add(new int[]{start, end});
        return true;
    }
}
