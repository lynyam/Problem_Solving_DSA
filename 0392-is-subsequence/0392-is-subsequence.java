class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int m = t.length();

        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        return (i == n);
        /*
        while (i < s.length()) {
            while (j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                    break;
                }
                j++;
            }
            if (i < s.length() && j == t.length()) return (false);
        }
        return (true);
        */
    }
}