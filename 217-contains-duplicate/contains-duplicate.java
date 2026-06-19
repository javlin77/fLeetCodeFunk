class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer>s=new HashSet<>();
        boolean res=false;
        for(int i:nums){
            if (s.contains(i)){
                res=true;
            }
            s.add(i);
        }
        return res;
    }
}