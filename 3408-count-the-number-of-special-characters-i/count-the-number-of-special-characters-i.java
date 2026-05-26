class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> s=new HashSet<>();
        for(char ch : word.toCharArray()){
            s.add(ch);
        }
        int res=0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (s.contains(ch) && s.contains(Character.toUpperCase(ch))) {
                res++;
            }
        }
        return res;
    }
}