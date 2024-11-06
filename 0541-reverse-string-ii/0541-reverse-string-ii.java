class Solution {
    public String reverseStr(String s, int k) {
        int i = 0;
        int j = k - 1;
        int n = s.length();
        char[] arr = s.toCharArray();

        if (j > n - 1) {
            j = n - 1;
        }
        while (i < n && j < n) {
            reverse(arr, i, j);
            i += 2 * k;
            j = j + 2 * k > n - 1 ? n - 1 : j + 2 * k; 
        }
        return (new String(arr));
    }

    public void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}