class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] counts = new int[26];
        int test = 0;
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (int c : counts) {
            if (c == 0)
                continue;
            if (test == 0) {
                test = c;
                continue;
            }
            if (test != c) return false;
        }
        return (true);
    }
}