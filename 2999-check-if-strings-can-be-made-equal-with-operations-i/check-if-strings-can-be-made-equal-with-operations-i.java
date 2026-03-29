class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.charAt(0) == s2.charAt(2) && s2.charAt(0) == s1.charAt(2) ) {
            return true;
        } else if (s1.charAt(1) == s2.charAt(3) && s2.charAt(1) == s1.charAt(3)) {
            return true;
        } else {
            return false;
        }
    }
}