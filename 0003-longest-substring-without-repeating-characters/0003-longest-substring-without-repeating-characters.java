class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int right = 0;
        int left = 0;
        Set<Character> checking = new HashSet<>();
        int result = 0;

        while (right < n)  {
            char c = s.charAt(right);
            while (checking.contains(c)) {
                checking.remove(s.charAt(left++));
            }
            checking.add(c);
            result = Math.max(result, right - left + 1);
            right++;
        }
        return (result);
    }
}