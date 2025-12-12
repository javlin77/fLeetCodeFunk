class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for(int i=2;i<=n-2;i++){
            List<Integer> l=new ArrayList<>();
            int temp=n;
            while(temp>0){
                l.add(temp%i);
                temp/=i;
            }
        int left = 0;
        int right = l.size()-1;
        while(left<right){
            if(l.get(left)!=l.get(right))
                return false;
            left++;
            right--;
            }
        }
        return true;
    }
}