class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Character, String> mapping = new HashMap<>();
        HashSet<String> mapped = new HashSet<>();
        int i = 0;

        while (i < pattern.length()) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (!mapping.containsKey(c) && mapped.contains(word))
                    return (false);
            if (mapping.containsKey(c) && !mapping.get(c).equals(word))
                return (false);
            mapping.put(c, word);
            mapped.add(word);
            i++;
        }
        return true;
    }
}