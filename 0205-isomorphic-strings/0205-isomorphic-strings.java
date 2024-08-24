class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> store = new HashMap<>();
        HashSet<Character> seen = new HashSet<>();
        int n = s.length();
        int i = 0;

        if (n != t.length())
            return (false);
        while (i < n) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if ((store.containsKey(c1) && !store.get(c1).equals(c2)) || 
                (!store.containsKey(c1) && seen.contains(c2)))
                return (false);
            else if (!store.containsKey(c1)) {
                store.put(c1, c2);
                seen.add(c2);
            }
            i++;
        }
        return (true);
    }
}
/**
    - s String
    - t String
    - s ans t isomorphic
        - char in s can be replaced to get t
 */