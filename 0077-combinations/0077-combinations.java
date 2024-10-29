class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 1, n, k);
        return (ans);
    }

    public void backtrack(List<Integer> curr, int i, int n, int k) {
        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return ;
        }
        while (i <= n) {
            curr.add(i);
            backtrack(curr, i + 1, n, k);
            curr.remove(curr.size() - 1);
            i++;
        }
    }
}