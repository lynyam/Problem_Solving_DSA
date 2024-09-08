class Solution {
    String[] map = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) 
            return (new ArrayList<>());
        ans = new ArrayList<>();
        backtrack(new StringBuilder(), 0, digits);
        return (ans);
    }

    public void backtrack(StringBuilder curr, int i, String digits) {
        int n = digits.length();
        if (i == n) {
            ans.add(new String(curr));
            return ;
        }
        int num = digits.charAt(i) - '0';
        String si = map[num];
        for (char c : si.toCharArray()) {
            curr.append(c);
            backtrack(curr, i + 1, digits);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
/**
    - string "2 to 9"
    - ret all possible letter comb that the number could represent
    - ret any order
    - 1 not map any letter 23 2(abc) 3(def)
        curr                        []
        curr        [a]             [b]         [c]
        curr    [d] [e] [f]     [d][e][f]      [d][e][f]
        if(curr.length == digits.length()) base case

        String[10] = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        for (i : digit)
            i = i - 0;



 */