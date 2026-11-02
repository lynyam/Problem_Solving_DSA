class Solution {
    public String reverseWords(String s) {
        int i = 0;
        int n = s.length();
        int right = 0;
        int left = 0;
        StringBuilder sb = new StringBuilder(n);

        while (i < n) {
            if (s.charAt(i) == ' ') {
                if (i != 0)
                    right = i - 1;
                while (right >= left) {
                    sb.append(s.charAt(right));
                    right--;
                }
                left = i + 1;
                sb.append(' ');
            }
            i++;
        }
        if (i == n) {
            right = i - 1;
            while (right >= left) {
                sb.append(s.charAt(right));
                right--;
            }
        }
        return sb.toString();
    }
}