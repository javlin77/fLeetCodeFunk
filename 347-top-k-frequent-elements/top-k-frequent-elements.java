class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i : nums) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (!m.get(a).equals(m.get(b))) {
                return m.get(b) - m.get(a);
            } else {
                return b - a;
            }
        });
        for (int key : m.keySet()) {
            pq.offer(key);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}