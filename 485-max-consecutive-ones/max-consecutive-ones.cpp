class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int java=0;
        int m=0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==1){
                java++;
                m=max(m,java);
            }
            else
            java=0;
            
        }
       return m; 
    }
};