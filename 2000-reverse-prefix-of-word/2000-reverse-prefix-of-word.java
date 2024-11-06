class Solution {
    public String reversePrefix(String word, char ch) {
        int j = 0;
        int n = word.length();
        char[] arr = word.toCharArray();

        while (j < n) {
            if (arr[j] == ch) {
                reverse(arr, 0, j);
                break ;
            }
            j++;
        }
        return (new String(arr));
    }

    public void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}