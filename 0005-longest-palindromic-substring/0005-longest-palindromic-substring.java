class Solution {
    String ans;
    public String longestPalindrome(String s) {
        ans = new String();
        int i = 0;
        int n = s.length();

        while (i < n) {
            evenPalindrome(i, n, s);
            oddPalindrome(i, n, s);
            i++;
        }
        return (ans);
    }

    public void evenPalindrome(int i, int n, String s) {
        int j = 1;
        while (i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j)) {
            j++;
        }
        if (ans.length() < j * 2 - 1)
            ans = s.substring(i - j + 1, i + j);
    }

    public void oddPalindrome(int i, int n, String s) {
        int j = 1;
        while (i - j + 1 >= 0 && i + j < n && s.charAt(i - j + 1) == s.charAt(i + j)) {
            j++;
        }
        if (ans.length() < (j - 1) * 2)
            ans = s.substring(i - j + 2, i + j);
    }
}
//bcacb
//01234. =2 -1 = 1
//         2-2 = 0
//         = 2-3 = x