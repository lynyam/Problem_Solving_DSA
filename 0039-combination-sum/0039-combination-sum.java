class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), 0, 0, candidates, target);
        return (ans);
    }

    public void backtrack(List<Integer> curr, int sum, int i, int[] candidates, int target) {
        if (sum == target) {
            ans.add(new ArrayList<Integer>(curr));
            return ;
        }
        int j = i;
        while (j < candidates.length) {
            int cand = candidates[j];
            if (sum + cand <= target) {
                curr.add(cand);
                backtrack(curr, sum + cand, j, candidates, target);
                curr.remove(curr.size() - 1);
            }
            j++;
        }

    }
}
/**
    - candidates[] distinct, target int
    - list of all unique comb of candidates / sum = target
    - ret comb in any order
    - choose candidates an unlimited number of times. two com uniq if freq diff

        [2 3 6 7]
                                                        []
        oldSum + cd = sum <= 7        [2]           [3]         [6]         [7]
                                [2]         [3] [6] [7]x
                        [2] [3]v[6]x[7]x    [3]
                x[2][3]x[]
 */