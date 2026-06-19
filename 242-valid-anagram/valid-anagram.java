class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> m=new HashMap<>();
        for(char c: s.toCharArray()){
            m.put(c,m.getOrDefault(c,0)-1);
        }
        for(char c: t.toCharArray()){
            m.put(c,m.getOrDefault(c,0)+1);
            if(m.get(c)>0){
                return false;
            }
        }
        return true;
    }
}