class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> alphabet = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            alphabet.add(c);
        }
        return alphabet.size() == 26;
    }
}