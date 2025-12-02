class Solution {
    public int[] constructRectangle(int area) {
      int w;
        for (w = (int) Math.sqrt(area); area % w != 0; w--) ;
        return new int[]{area / w, w};  
    }
}