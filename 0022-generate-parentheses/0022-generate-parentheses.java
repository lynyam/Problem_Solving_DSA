class Solution {
    List<String> ans;
    int size;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList();
        size = n;
        backtrack(new StringBuilder(), 0, 0);
        return (ans);
    }

    public void backtrack(StringBuilder curr, int open, int close) {
        if (curr.length() == size * 2) {
            ans.add(new String(curr));
            return ;
        }
        if (open < size) {
            curr.append("(");
            backtrack(curr, open + 1, close);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (open > close) {
            curr.append(")");
            backtrack(curr, open, close + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
/**
    - n pairs of parentheses
    - write func to generate all comb of well-formed parenth
    - base case
        open == 0 && close == 0 && stack.isEMpty() || curr.length == n x 2

    -   ()()()
                        []
   1             (               )
   2         (      )
   2    (   )        (
   1  )
   )
 )           

 */