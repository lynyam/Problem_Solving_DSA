class Solution {
    HashSet<List<Integer>> seen;
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        seen = new HashSet<>();
        ans = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), 0, candidates, target);
        return (ans);
    }

    public void backtrack(List<Integer> curr, int sum, int[] candidates, int target) {
        if (sum >= target) {
            if (sum == target) {
                List<Integer> list = new ArrayList<>(curr);
                Collections.sort(list);
                if(!seen.contains(list)) {
                    seen.add(list);
                    ans.add(list);
                }
            }
            return ;
        }
        for (int num : candidates) {
            if (sum + num <= target) {
                curr.add(num);
                backtrack(curr, sum + num, candidates, target);
                curr.remove(curr.size() - 1);
            }
        }

    }
}
/**
    - candidates[] distinct int, target int
    - ret a list of all unique comb of cand chosen num sun = target
    - any order, same a number more time than 1
    - comb uniq = freq of at least num difff
    - res less than 150 comb
            curr []
    [2]         [3]     [6]     [7]
  [2] [3] [6] [7]

  if (sum >= 7)
    if(!HS.contains(curr))
        add
    return ;
    
 */