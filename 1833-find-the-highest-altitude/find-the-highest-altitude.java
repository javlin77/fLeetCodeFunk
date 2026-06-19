class Solution {
  public int largestAltitude(int[] gain) {
    int curr = 0;
    int res = curr;
    for (int i : gain) {
      curr += i;
      res = Math.max(res, curr);
    }

    return res;
  }
}