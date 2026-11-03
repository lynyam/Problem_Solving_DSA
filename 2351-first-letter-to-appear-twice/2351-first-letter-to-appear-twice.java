class Solution {
    public char repeatedCharacter(String s) {
        boolean[] alphabet = new boolean[26];

        for (char c : s.toCharArray()) {
            if (alphabet[c - 'a'])
                return (c);
            alphabet[c - 'a'] = true;
        }
        return ' ';
    }
}