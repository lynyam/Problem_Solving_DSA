class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] alphabet = new boolean[26];
        int count = 0;
        for (char c : sentence.toCharArray()) {
            if (!alphabet[c - 'a']) {
                count++;
                alphabet[c - 'a'] = true;
            }
        }
        return count == 26;
    }
}