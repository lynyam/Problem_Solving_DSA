class Solution {
    public boolean checkIfPangram(String sentence) {
        int alphabet = 0;
        for (char c : sentence.toCharArray()) {
            if ((alphabet & (1 << (c - 'a'))) == 0) {
                alphabet |= (1 << (c - 'a'));
            }
        }
        return alphabet == (1 << 26) - 1;
    }
}