class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int l = 0;
        for (int i : candies) {
            if (i > l) l = i;
        }
        for (int i : candies) {
            result.add(i + extraCandies >= l);
        }
        
        return result;
    }
}
