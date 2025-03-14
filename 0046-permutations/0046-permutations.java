class Solution {
    public List<List<Integer>> permute(int[] nums) {
	int n = nums.length;
	List<List<Integer>> result = new ArrayList<>();
	backtrack(new ArrayList<>(), new HashSet<Integer>(), result, n, nums);
	return (result);
    }


    public void backtrack(List<Integer> curr, HashSet<Integer> set, List<List<Integer>> result, int n, int[] nums) {
        if (curr.size() == n) {
            result.add(new ArrayList<Integer>(curr));
            return ;
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (!set.contains(num)) {
                set.add(num);
                curr.add(num);
                backtrack(curr, set, result, n, nums);
                set.remove(num);
                curr.remove(curr.size() - 1);
            }
        }
    }
}