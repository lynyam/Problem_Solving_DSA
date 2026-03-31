class Solution {
    public String mergeAlternately(String word1, String word2) {
        int index1 = 0;
        int index2 = 0;
        int n1 = word1.length();
        int n2 = word2.length();
        StringBuilder result = new StringBuilder();

        while (index1 < n1 && index2 < n2) {
            result.append(word1.charAt(index1))
                .append(word2.charAt(index2));
            index1++;
            index2++;
        }
        while (index1 < n1) {
            result.append(word1.charAt(index1++));
        }
        while (index2 < n2) {
            result.append(word2.charAt(index2++));
        }
        return (result.toString());
    }
}