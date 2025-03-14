class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), 0, result, nums, nums.length);
        return (result);
    }


    public void backtrack(List<Integer> curr, int index, List<List<Integer>> result, int[] nums, int n) {
        result.add(new ArrayList<Integer>(curr));
        for (int i = index; i < n; i++) {
            curr.add(nums[i]);
            backtrack(curr, i + 1, result, nums,  n);
            curr.remove(curr.size() - 1);	
        }
    }
}
