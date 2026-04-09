class Solution {
    public int mirrorDistance(int n) {
        int m=0;
        int a=n;
        while(a>0){
            int r=a%10;
            m=m*10+r;
            a=a/10;
        }
        return Math.abs(n-m);
    }
}