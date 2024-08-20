class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> seen = new HashSet<>();
        int ans = 0;

        for (char c : jewels.toCharArray()) {
            seen.add(c);
        }
        for (char c2 : stones.toCharArray()) {
            ans += !seen.contains(c2) ? 0 : 1;
        }
        return (ans);
    }
}
/**
    - jewels String
        - types of stones that are jewels
    - stones reprensent the stones u have
    - char in stones = type of stone u have
    - how many of stones u have are also jewels
 */