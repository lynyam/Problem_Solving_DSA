class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), 1, n, k);
        return (ans);
    }

    public void backtrack(List<Integer> curr, int i, int n, int k) {
        if (curr.size() == k) {
            ans.add(new ArrayList<Integer>(curr));
            return ;
        }
        int j = i;
        while (j <= n) {
            curr.add(j);
            backtrack(curr, j + 1, n, k);
            curr.remove(curr.size() - 1);
            j++;
        }
    }
}
/**
    - n, k int
    - return all possible comb of k numbers [1, n] (k/n)
    SOlution
                            []
                    [1]     [2]     [3]     [4]
                [2] [3] [4]

 */