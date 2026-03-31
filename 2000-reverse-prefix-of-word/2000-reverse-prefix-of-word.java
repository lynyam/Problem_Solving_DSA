class Solution {
    public String reversePrefix(String word, char ch) {
        int i = 0;
        int n = word.length();
        while (i < n) {
            if (word.charAt(i) == ch)
                break;
            i++;
        }
        if (i == n) return (word);
        char[] wordArr = word.toCharArray();
        int j = 0;
        while (j < i) {
            wordArr[i] = wordArr[j];
            wordArr[j] = word.charAt(i);
            i--;
            j++;
        }
        return (new String(wordArr));
    }
}