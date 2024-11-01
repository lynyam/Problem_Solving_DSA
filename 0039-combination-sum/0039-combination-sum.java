class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, 0, candidates, target);
        return (ans);
    }

    public void backtrack(List<Integer> curr, int i, int sum, int[] candidates, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
            return ;
        }
        while (i < candidates.length) {
            if (sum + candidates[i] <= target) {
                curr.add(candidates[i]);
                backtrack(curr, i, sum + candidates[i], candidates, target);
                curr.remove(curr.size() - 1);
            }
            i++;
        }
    }
}