class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList();
        backtrack(new ArrayList<>(), 0, nums);
        return (ans);
    }

    public void backtrack(List<Integer> curr, int i, int[] nums) {
        ans.add(new ArrayList<>(curr));
        while (i < nums.length) {
            curr.add(nums[i]);
            backtrack(curr, i + 1, nums);
            curr.remove(curr.size() - 1);
            i++;
        }
    }
}