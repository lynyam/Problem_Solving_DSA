class Solution {
    public int maxVowels(String s, int k) {
        int right = 0;
        int left = 0;
        int n = s.length();
        int ans = 0;
        int vowelsCount = 0;

        while (right < k) {
            vowelsCount += is_vowels(s.charAt(right++)) ? 1 : 0;
        }
        ans = vowelsCount;
        while (right < n) {
            vowelsCount += is_vowels(s.charAt(right)) ? 1 : 0;
            vowelsCount -= is_vowels(s.charAt(left)) ? 1 : 0;
            ans = Math.max(ans, vowelsCount);
            right++;
            left++;
        }
        return (ans);
    }
    
    public  boolean is_vowels(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}