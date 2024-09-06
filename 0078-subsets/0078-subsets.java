class Solution {
    List<List<Integer>> ans; 
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        backtrack(0, new ArrayList<Integer>(), nums);
        return (ans);
    }

    public void backtrack(int i, List<Integer> curr, int[] nums) {
        if (i > nums.length) {
            return ;
        }
        ans.add(new ArrayList<Integer>(curr));
        int j = i;
        while (j < nums.length) {
            int num = nums[j];
            curr.add(num);
            backtrack(j + 1, curr, nums);
            curr.remove(curr.size() - 1);
            j++;
        }
    }
}
/**
    - nums[] 
    - ret all posssible subsets (the power set) backtracking
    - not dupplicate subset
 */