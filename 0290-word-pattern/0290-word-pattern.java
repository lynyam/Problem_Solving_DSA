class Solution {
    public boolean wordPattern(String pattern, String s) {
        int p = pattern.length();
        String[] strs = s.split(" ");
        int n = strs.length;
        HashMap<Character, String> store = new HashMap<>(); //0(s) space
        HashSet<String> seen = new HashSet<>(); // 0(s)
        int i = 0;

        if (p != n)
            return (false);
        while (i < n) {
            char c = pattern.charAt(i);
            String str = strs[i];
            if (store.containsKey(c) && !store.get(c).equals(str))
                return (false);
            if (!store.containsKey(c) && seen.contains(str))
                return (false);
            if (!store.containsKey(c)) {
                store.put(c, str);
                seen.add(str);
            }
            i++;
        }
        return (true);
    }
}
/**
    - pattern String
    - s string
    - find if s follow the same pattern
        - mean: full match, bijection between a letter in pattern and nn-empty word s
    ex:pattern = "abba", s = "dog cat cat dog"
 */