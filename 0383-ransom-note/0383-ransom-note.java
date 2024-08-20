class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> store = new HashMap<>();
        
        for (char c : magazine.toCharArray()) {
            store.put(c, store.getOrDefault(c, 0) + 1);
        }
        for (char c1 : ransomNote.toCharArray()) {
            store.put(c1, store.getOrDefault(c1, 0) - 1);
            if (store.get(c1) < 0)
                return (false);
        }
        return (true);
    }
}