class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, nums);
        return (ans);
    }

    public void backtrack(List<Integer> curr, int i, int[] nums) {
        ans.add(new ArrayList<>(curr));
        int j = i;
        while (j < nums.length) {
            curr.add(nums[j]);
            backtrack(curr, j + 1, nums);
            curr.remove(curr.size() - 1);
            j++;
        }
    }
}
/**
    - nums int[] unique elt
    - ret all possible subset
    - not contains duplicate subset, any order

                                                []
                        [1]                     [2]                     [3]
                    [1 2] [1 3]         [2 3]
            [1 2 3]
 */