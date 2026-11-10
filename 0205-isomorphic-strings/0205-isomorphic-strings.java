class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> mapping = new HashMap<>();
        HashSet<Character> mapped = new HashSet<>();
        int i = 0;

        while (i < s.length()) {
            char s_char = s.charAt(i);
            char t_char = t.charAt(i);

            if (!mapping.containsKey(s_char) && mapped.contains(t_char))
                    return (false);
            if (mapping.containsKey(s_char) && !mapping.get(s_char).equals(t_char))
                return (false);
            mapping.put(s_char, t_char);
            mapped.add(t_char);
            i++;
        }
        return true;
    }
    //- if s[i] == t[i] of
}