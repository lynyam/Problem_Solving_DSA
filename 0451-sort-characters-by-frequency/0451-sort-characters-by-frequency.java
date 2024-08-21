class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> store = new HashMap<>();
        int max = 0;

        for (char c : s.toCharArray()) {
            store.put(c, store.getOrDefault(c, 0) + 1);
            max = Math.max(max, store.get(c));
        }
        List<List<Character>> buckets = new ArrayList<>();
        int i = 0;
        while (i <= max) {
            buckets.add(new ArrayList<>());
            i++;
        }
        for (Character key : store.keySet()) {
            int freq = store.get(key);
            buckets.get(freq).add(key);
        }
        StringBuilder sb = new StringBuilder();
        i = max;
        while (i > 0) {
            List<Character> currList = buckets.get(i);
            for (char ci : currList) {
                int j = 0;
                while (j < i) {
                    sb.append(ci);
                    j++;
                }
            }
            i--;
        }
        return (sb.toString());
    }
}
/**
    - s string
    - sort in decreasing order based on the frequency of char
 */