class Solution {
    List<List<Integer>> answer;
    int n, k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        answer = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), 1);
        return (answer);
    }

    public void backtrack(List<Integer> curr, int i) {
        if (curr.size() == k) {
            answer.add(new ArrayList<>(curr));
            return ;
        }
        while (i <= n) {
            curr.add(i);
            backtrack(curr, i + 1);
            curr.remove(curr.size() - 1);
            i++;
        }
    }
}