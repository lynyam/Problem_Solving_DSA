class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> store = new HashMap<>();
        for (char c : s.toCharArray()) {
            store.put(c, store.getOrDefault(c, 0) + 1);
        }
        return (new HashSet<Integer>(store.values()).size() == 1);
    }
}