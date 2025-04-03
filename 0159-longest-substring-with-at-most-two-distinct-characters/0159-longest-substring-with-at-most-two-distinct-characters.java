class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> counting = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        int result = 0;

        while (right < n) {
            char c = s.charAt(right);
            counting.put(c, counting.getOrDefault(c, 0) + 1);
            while (counting.size() > 2) {
                char CL = s.charAt(left);
                counting.put(CL, counting.getOrDefault(CL, 0) - 1);
                if (counting.get(CL) <= 0) counting.remove(CL);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return (result);
    }
}