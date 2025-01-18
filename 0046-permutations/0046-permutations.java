class Solution {
    List<List<Integer>> answer;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        this.nums = nums;
        backtrack(new ArrayList<Integer>(), new HashSet<Integer>());
        return (answer);
    }

    public void backtrack(List<Integer> curr, HashSet<Integer> check) {
        if (curr.size() == nums.length) {
            answer.add(new ArrayList<Integer>(curr));
            return ;
        }
        for (int num : nums) {
            if (!check.contains(num)) {
                curr.add(num);
                check.add(num);
                backtrack(curr, check);
                curr.remove(curr.size() - 1);
                check.remove(num);
            }
        }
    }
}