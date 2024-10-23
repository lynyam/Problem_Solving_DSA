class Solution {
    int ans;
    public int countSubstrings(String s) {
        int i = 0;
        int n = s.length();
        ans = 0;

        while (i < n) {
            evenPalindrome(i, n, s);
            oddPalindrome(i, n, s);
            i++;
        }
        return (ans);
    }

    public void evenPalindrome(int i, int n, String s) {
        int j = 0;
        while (i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j)) {
            j++;
            ans++;
        }
    }

    public void oddPalindrome(int i, int n, String s) {
        int j = 1;
        while (i - j + 1 >= 0 && i + j < n && s.charAt(i - j + 1) == s.charAt(i + j)) {
            j++;
            ans++;
        }
    }
}