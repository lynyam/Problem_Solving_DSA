class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = arr.length;

        for (String str : arr) {
            sb.append(reverse(str.toCharArray()));
            if (i != n - 1)
                sb.append(' ');
            i++;
        }
        return (sb.toString());
    }

    public char[] reverse(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return s;
    }
}