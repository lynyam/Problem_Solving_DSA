class Solution {
    public char repeatedCharacter(String s) {
        HashSet<Character> store = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (store.contains(c))
                return (c);
            store.add(c);
        }
        return (0);
    }
}