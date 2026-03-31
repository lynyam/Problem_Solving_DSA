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
        return (new StringBuilder())
                .append(
                    (new StringBuilder())
                        .append(
                                word.substring(0, i + 1))
                    .reverse())
                .append(word.substring(i + 1)).toString();
    }
}