class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), 1, k, n);
        return (ans);
    }
    public void backtrack(List<Integer> curr, int i, int k, int n) {
        if (curr.size() == k) {
            ans.add(new ArrayList<Integer>(curr));
            return ;
        }
        int j = i;
        while (j <= n) {
            curr.add(j);
            backtrack(curr, j + 1, k, n);
            curr.remove(curr.size() - 1);
            j++;
        }
    }
}
/**
    - int n, int k
    - all possible combinaisons of k numbers chosen from range [1, n]
    - ans in order
 */