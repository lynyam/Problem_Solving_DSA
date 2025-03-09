class Solution {
    public int[] divisibilityArray(String word, int m) {
        if (word.isEmpty()) return (new int[0]);
        int n  = word.length();
        int moduloTen = 10 % m;
        int[] result = new int[n];
        int curr = (word.charAt(0) - '0') % m;
        result[0] = curr == 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            curr = ((curr * moduloTen) + ((word.charAt(i) - '0') % m)) % m;
            result[i] = curr == 0 ? 1 : 0;
        }
        return (result);
    }
}