class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right = 0;
        int left = 0;
        int ans = 0;
        HashSet<Character> seen = new HashSet<>();
        int n = s.length();

        while (right < n) {
            char cr = s.charAt(right);
            if (!seen.contains(cr)) {
                seen.add(cr);
            } else {
                while (s.charAt(left) != cr) {
                    seen.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
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