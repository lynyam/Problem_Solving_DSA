class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> alphabet = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (alphabet.contains(c))
                return (c);
            alphabet.add(c);
        }
        return ' ';
    }
}