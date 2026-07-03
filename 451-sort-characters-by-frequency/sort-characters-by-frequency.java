class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        List<Character> l = new ArrayList<>(m.keySet());
        l.sort((a, b) -> {
            return m.get(b) - m.get(a);
        });
        StringBuilder sb = new StringBuilder();
        for (char c : l) {
            for (int i = 0; i < m.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}