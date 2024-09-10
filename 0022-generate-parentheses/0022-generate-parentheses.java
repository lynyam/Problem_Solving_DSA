class Solution {
    ArrayList<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n);
        return (ans);
    }

    public void backtrack(StringBuilder curr, int open, int close, int n) {
        if (curr.length() == 2 * n) {
            ans.add(new String(curr));
            return ;
        }
        if (open < n) {
            curr.append("(");
            backtrack(curr, open + 1, close, n);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (open > close) {
            curr.append(")");
            backtrack(curr, open, close + 1, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
/**
    - n pairs ()
    - write func to generate all comb of well=formed parenth
 */