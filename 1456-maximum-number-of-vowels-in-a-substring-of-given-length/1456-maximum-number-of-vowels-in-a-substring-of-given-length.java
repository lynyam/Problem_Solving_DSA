class Solution {
    public int maxVowels(String s, int k) {
        int curr = 0;
        int n = s.length();
        if (k > n) return 0;
        
        int i = 0;
        int result = 0;
        while (i < k) {
            if (isVowel(s.charAt(i)))
                curr++;
            i++;
        }
        result = Math.max(result, curr);
        while (i < n) {
            if (isVowel(s.charAt(i)))
                curr++;
            if (isVowel(s.charAt(i - k)))
                curr--;
            result = Math.max(result, curr);
            i++;
        }
        return (result);
    }

    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i'
            || c == 'o' || c == 'u');
    }
}