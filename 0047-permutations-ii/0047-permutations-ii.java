public class Solution {
	Set<List<Integer>> result;
	int n;
    int[] nums;
	public List<List<Integer>> permuteUnique(int[] nums) {
		result = new HashSet<>();
        n = nums.length;
        this.nums = nums;
		backtrack(new ArrayList<>(), new HashSet<Integer>());
        List<List<Integer>> convertResult = new ArrayList<>();
        convertResult.addAll(result);
		return (convertResult);
	}


	public void backtrack(List<Integer> curr, Set<Integer> checkIndex) {
		if (curr.size() == n) {
			result.add(new ArrayList<Integer>(curr));
		}
		for (int i = 0; i < n; i++) {
			if (!checkIndex.contains(i)) {
				checkIndex.add(i);//0
				curr.add(nums[i]); //123, 
				backtrack(curr, checkIndex);
				curr.remove(curr.size() - 1);
				checkIndex.remove(i);
			}
		}
	}
}