class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> counts = new HashMap<>();

        int i = 0;
        int min = Integer.MAX_VALUE;
        int max = 1;
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (char c : counts.keySet()) {
            min = Math.min(min, counts.get(c));
            max = Math.max(max, counts.get(c));
        }
        List<List<Character>> buckets = new ArrayList<>(max - min + 1);
        while (i < max - min + 1)
        {
            buckets.add(new ArrayList<Character>());
            i++;
        }
        for (char c : counts.keySet())
            buckets.get(counts.get(c) - min).add(c);
        StringBuilder result = new StringBuilder();
        i = max - min;
        while (i >= 0) {
            List<Character> curr = buckets.get(i);
            if (curr.size() == 0) {
                i--;
                continue;
            }
            for (char c : curr) {
                int j = 0;
                while (j < i + min) {
                    result.append(c);
                    j++;
                }
            }
            System.out.println(result);
            i--;
        }
        return result.toString();
    }
}