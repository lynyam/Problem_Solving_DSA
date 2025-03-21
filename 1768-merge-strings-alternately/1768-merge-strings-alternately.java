class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int n = word1.length();
        int m = word2.length();
        char[] result = new char[n + m];
        while (i < n && j < m) {
            result[k] = k % 2 == 0 ? word1.charAt(i++) : word2.charAt(j++);
            k++;
        }
        while (i < n){
            result[k] = word1.charAt(i++);
            k++;
        }
        while (j < m){
            result[k] = word2.charAt(j++);
            k++;
        }
        return (new String(result));
    }
}