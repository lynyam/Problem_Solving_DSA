class Solution {
    public String reverseOnlyLetters(String s) {
        int i = 0;
        int n = s.length();
        int j = n - 1;
        char[] arr = s.toCharArray();

        while (i < j) {
            if (!isEnLetters(arr[i])) {
                i++;
                continue ;
            }
            if (!isEnLetters(arr[j])) {
                j--;
                continue ;
            }
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return (new String(arr));
    }

    public boolean isEnLetters(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
}