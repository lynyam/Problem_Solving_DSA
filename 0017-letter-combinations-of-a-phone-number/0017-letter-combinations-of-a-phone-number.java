class Solution {
    String[] matching = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> answer;
    String digits;
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return (new ArrayList());
        answer = new ArrayList<>();
        this.digits = digits;
        backtrack(new StringBuilder(), 0);
        return (answer);
    }

    public void backtrack(StringBuilder curr, int index) {
        if (curr.length() == digits.length()) {
            answer.add(new String(curr));
            return ;
        }
        for (char c : matching[digits.charAt(index) - '0'].toCharArray()) {
            curr.append(c);
            backtrack(curr, index + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

}