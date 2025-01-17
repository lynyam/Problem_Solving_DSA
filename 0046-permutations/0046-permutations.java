class Solution {
    List<List<Integer>> answer;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        answer = new ArrayList<>(); 
        backtrack(new ArrayList<Integer>());
        return (answer);
    }

    public void backtrack(List<Integer> curr) {
        if (curr.size() == nums.length) {
            answer.add(new ArrayList<Integer>(curr));
            return ;
        }
        for (int num : nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}