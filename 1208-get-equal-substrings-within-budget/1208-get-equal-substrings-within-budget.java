class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int left, right;
        left = right = 0;
        int result = 0;
        int curr = 0;

        while (right < n) {
            curr += Math.abs(s.charAt(right) - t.charAt(right));
            while (curr > maxCost) {
                curr -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}