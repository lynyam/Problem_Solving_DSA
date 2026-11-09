class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] check = new int[26];
        for (char c : s.toCharArray()) {
            check[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            check[c - 'a']--;
            if (check[c - 'a'] < 0)
                return (false);
        }
        return (true);
    }
}