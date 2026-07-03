class Solution {
    public int majorityElement(int[] nums) {
       HashMap<Integer, Integer> m = new HashMap<>();
        int c = 0;
        int res=0;
        for (int i : nums) {
            m.put(i, m.getOrDefault(i, 0) + 1);
            if(m.get(i)>c){
                c=m.get(i);
                res=i;
            }
        }
        return res; 
    }
}