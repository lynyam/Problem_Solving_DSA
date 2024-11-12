class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right = 0;
        int left = 0;
        int ans = 0;
        HashSet<Character> seen = new HashSet<>();
        int n = s.length();

        while (right < n) {
            char cr = s.charAt(right);
            while (seen.contains(cr)) {
                    seen.remove(s.charAt(left));
                    left++;
            }
            seen.add(cr);
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return (ans);
    }
}
/**
    - s String
    - find longest substring without repeating char
 */