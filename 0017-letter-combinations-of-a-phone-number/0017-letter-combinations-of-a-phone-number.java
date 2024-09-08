class Solution {
    String[] map = new String[]{
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return (new ArrayList<>());
        ans = new ArrayList<>();
        backtrack(new StringBuilder(), digits, 0);
        return (ans);
    }

    public void backtrack(StringBuilder curr, String digits, int i) {
        if (i == digits.length()) {
            ans.add(new String(curr));
            return ;
        }
        String str = map[digits.charAt(i) - '0'];
        for (char c : str.toCharArray()) {
            curr.append(c);
            backtrack(curr, digits, i + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
/**
    - string digit 2-9
    - ret all possible comb that the number could represent
    
        "23"
                                []
        2           [a]         [b]         [c]
        3        [d] [e] [f]  [d][e][f]   [d][e][f]
        => leaf => result
            base case (curr.length == digits.length)
            str = map[i]
            while (c : str)
                bcktr(curr, i + 1, ..)
 */