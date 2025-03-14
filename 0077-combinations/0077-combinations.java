class Solution {
    public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result  = new ArrayList<>();
		if (k == 0) return (result);
        backtrack(new ArrayList<Integer>(), 1, result, n, k);
        return (result); 
    }


    public void backtrack(List<Integer> curr, int index, List<List<Integer>> result, int n, int k) {
        if (curr.size() == k) {
            result.add(new ArrayList<Integer>(curr));
            return ;
        }
        for (int i = index; i <= n; i++) {
            curr.add(i);
            backtrack(curr, i + 1, result, n, k);
            curr.remove(curr.size() - 1);
        }
    }
}