class Solution {
    public String reverseOnlyLetters(String s) {
        int left, right;
        right = s.length() - 1;
        left = 0;
        char[] temp = s.toCharArray();

        while (left < right) {
            if (isEngLetter(temp[left]) && 
                isEngLetter(temp[right])) {
                    temp[left] = s.charAt(right);
                    temp[right] = s.charAt(left);
                    right--;
                    left++;
                continue;
            }
            if (!isEngLetter(temp[right]))
                right--;
            if (!isEngLetter(temp[left]))
                left++;
        }
        return new String(temp);
    }


    private boolean isEngLetter(char c) {
        return (c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z');
    }
}