class Solution {
    String[] map = new String[] {"", "", "abc", "def", "ghi",
                                    "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return (new ArrayList<>());
        ans = new ArrayList<>();
        backtrack(new StringBuilder(), 0, digits);
        return (ans);
    }

    public void backtrack(StringBuilder curr, int i, String digits) {
        if (i >= digits.length()) {
            ans.add(new String(curr));
            return ;
        }
        for (char c : map[digits.charAt(i) - '0'].toCharArray()) {
            curr.append(c);
            backtrack(curr, i + 1, digits);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
