class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int res=0;
        int n=nums.length;
        int [] ans=new int[n];
        for(int num : nums){
            res+=num;
        }
        int ls=0;
        for(int i=0;i<n;i++){
            int rs=res-ls-nums[i];
            int lc=i;
            int rc=n-1-i;
            int lres=lc*nums[i]- ls;
            int rres=rs-rc*nums[i];
            ans[i]=lres+rres;
            ls+=nums[i];


        }
        return ans;
    }
}