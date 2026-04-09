class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        if(x==100) return 1;
        int d=x;
        int a=d%10;
        d/=10;
        a+=d%10;
        return x%a==0 ? a : -1;
    }
}