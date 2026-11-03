class Solution {
    public boolean checkIfPangram(String sentence) {
        int alphabet = 0;
        int count = 0;
        for (char c : sentence.toCharArray()) {
            if ((alphabet & (1 << (c - 'a'))) == 0) {
                //System.out.println(alphabet);
                count++;
                alphabet |= (1 << (c - 'a'));
            }
        }
        return count == 26;
    }
}