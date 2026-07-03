class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        List<Character> l = new ArrayList<>();
        for (char c : s.toCharArray()) {
            l.add(c);
        }
        l.sort((a, b) -> {
            if (!m.get(a).equals(m.get(b))) {
                return m.get(b) - m.get(a); 
            } else {
                return a - b; 
            }
        });
        StringBuilder sb = new StringBuilder();
        for (char c : l) {
            sb.append(c);
        }
        return sb.toString();
    }
}