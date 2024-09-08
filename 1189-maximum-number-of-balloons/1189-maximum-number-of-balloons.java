class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> store = new HashMap<>();

        for (char c : text.toCharArray()) {
            store.put(c, store.getOrDefault(c, 0) + 1);
        }
        return (Math.min(store.getOrDefault('b', 0), Math.min(store.getOrDefault('a', 0), 
            Math.min(store.getOrDefault('l', 0) / 2, Math.min(store.getOrDefault('o', 0) / 2, 
            store.getOrDefault('n', 0))))));
    }
}
/**
    - text String
    - text[i] to form "balloon"
    - use char just 1.
    - ret max number of instances
 */