class Solution {
    List<List<Integer>> ans;
    int n;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        ans = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), 1, k);
        return (ans);
    }

    public void backtrack(List<Integer> curr, int i, int k) {
        if (curr.size() == k) {
            ans.add(new ArrayList<Integer>(curr));
            return ;
        }
        int j = i;
        while (j <= n) {
            curr.add(j);
            backtrack(curr, j + 1, k);
            curr.remove(curr.size() - 1);
            j++;
        }
    }
}
/**
    - n, k int
    - ret comb(knumber) range[1, n] any order 
    k = 2 n = 4 => 1, 2, 3, 4
                            []
                [1]        [2]     [3]      [4]
            [1 2]         [2 3]    [3 4]
 */