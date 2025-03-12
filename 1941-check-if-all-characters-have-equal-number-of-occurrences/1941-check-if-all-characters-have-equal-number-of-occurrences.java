class Solution {
	public boolean areOccurrencesEqual(String s) {
		if (s.isEmpty()) return (true);
		HashMap<Character, Integer> frequency = new HashMap<>();
		
		for (char c : s.toCharArray()) {
			frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        return  (new HashSet<Integer>(frequency.values()).size() == 1);
    }
}
