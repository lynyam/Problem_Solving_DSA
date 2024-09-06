class Solution {
    List<List<Integer>> ans; 
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();//0(n2exp(n-1)) space
        backtrack(new ArrayList<Integer>(), nums);
        return (ans);
    }

    public void backtrack(List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<Integer>(curr));
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
    - nums[] unique elt
    - ret all possible subset (all of something => backtrack)
    - make exhaustive  possibilite 0(3pow3) = 27 and walk throught to chose on k who not dublicate
    or backtrack 0(2exp2)
 */