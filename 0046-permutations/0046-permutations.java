class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(curr, nums);
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
    - nums[] distinct int
    - ret all possible perutation

    Solution
    - make exhaustive permutation and eliminate all of them wo one number has duplicate.Note a good idea nexpn+2
    - make backtrack
        - create curr List<Int>
        - base case : if (curr.size == n) ans.add(copy of curr) just don't copy ref because null after all
        - for loop on num: make ckeck if num : nums contains in curr 0(n) 
            - if no add to curr and call backtrack => reduce to don't no
            - delete last add in curr to back to parent and explore another child
 */