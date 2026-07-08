class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> m = new HashMap<>();
		for (char c : tasks) {
			m.put(c, m.getOrDefault(c, 0) + 1);
		}
		int maxFreq = 0;
		for (int val : m.values()) {
			maxFreq = Math.max(maxFreq, val);
		}
		int maxFreqCount = 0;
		for (int val : m.values()) {
			if (val == maxFreq) {
				maxFreqCount++;
			}
		}
		int res = (maxFreq - 1) * (n + 1) + maxFreqCount;
		return Math.max(tasks.length, res);
    }
}