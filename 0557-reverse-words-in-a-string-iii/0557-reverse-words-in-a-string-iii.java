class Solution {
    public String reverseWords(String s) {
        int i = 0;
        int n = s.length();
        int right = 0;
        int left = 0;
        StringBuilder sb = new StringBuilder(n);

        while (i < n) {
            if (s.charAt(i) == ' ' || i == n - 1) {
                right = s.charAt(i) == ' ' ? i - 1 : i;
                while (right >= left) {
                    sb.append(s.charAt(right));
                    right--;
                }
                left = i + 1;
                if (i < n - 1)
                    sb.append(' ');
            }
            i++;
        }
        return sb.toString();
    }
}