class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for(String s:strs){
            char [] c = s.toCharArray();
            Arrays.sort(c);
            String res= new String(c);
            m.putIfAbsent(res,new ArrayList<>());
            m.get(res).add(s);
        }
        return new ArrayList<>(m.values());
    }
}