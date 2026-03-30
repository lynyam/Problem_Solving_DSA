class Solution {
    public String reverseOnlyLetters(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] result = s.toCharArray();

        while (start < end) {
            char up = s.charAt(start);
            char down = s.charAt(end);

            if (isLetter(up) && isLetter(down)) {
                result[start] = down;
                result[end] = up;
                start++;
                end--;
            } else if (!isLetter(up)) {
                start++;
            } else if (!isLetter(down)) {
                end--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        return (sb.toString());
    }

    public boolean isLetter(char c) {
        return ((c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z'));
    }
}