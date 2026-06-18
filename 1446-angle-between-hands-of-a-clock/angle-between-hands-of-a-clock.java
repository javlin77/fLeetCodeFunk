class Solution {
    public double angleClock(int hour, int minutes) {
        double hh = hour * 30 % 360 + minutes * 0.5;
        double mh = minutes * 6;   
        double res = Math.abs(mh - hh);   
        return Math.min(res, 360 - res);
    }
}