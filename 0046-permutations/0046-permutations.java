class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return (new ArrayList<>());
        backtrack(new ArrayList<Integer>(), nums);
        return (ans);
    }

    public void backtrack(List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return ;
        }
        for (int num : nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
/**
    - nums[]
    - ret all the possible permutations
    - in any  order
 */