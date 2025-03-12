class Solution {
	public List<Integer> intersection(int[][] nums) {
		int n = nums.length;
		HashMap<Integer, Integer> frequency = new HashMap<>();//0(nk) space
		for (int[] arr : nums) {//0(n)
			for (int num : arr) {//0(k)
				frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int key : frequency.keySet()) {
            if (frequency.get(key) == n) {
                result.add(key);
            }
        }
        Collections.sort(result);//0(klogk)
        return (result);//0(nk * klogk) = 0(k(n + logk))
    }
}


