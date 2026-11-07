class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] set = new boolean[128];
        int result = 0;
        
        for (char c : jewels.toCharArray()) {
            set[c] = true;
        }
        for (char c : stones.toCharArray()) {
            if (set[c] == true)
                result++;
        }
        return (result);
    }
}