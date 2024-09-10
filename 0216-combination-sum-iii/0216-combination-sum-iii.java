class Solution {
    List<List<Integer>> ans;
    int k;
    int sum;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        this.k = k;
        sum = n;
        backtrack(new ArrayList<Integer>(), 1,  0, 0);
        return (ans);
    }

    public void backtrack(List<Integer> curr, int start, int i, int total) {
        if (i == k) {
            if (total == sum)
                ans.add(new ArrayList<Integer>(curr));
            return ;
        }
        while (start <= 9) {
            if (total + start <= sum) {
                curr.add(start);
                backtrack(curr, start + 1, i + 1, total + start);
                curr.remove(curr.size() - 1);
            }
            start++;
        }
    }
}
/**
    - valid comb of k number sum up to n
        - only number 1-9
        - each number used most once
    - ret list of all possible comb.

    base case   curr.length == k
 */
            
        