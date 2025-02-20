class	Solution {
	String[] buttons = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
};
	String digits;
	List<String> answer;
	int n;
	public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return (new ArrayList());
		this.digits = digits;
		answer = new ArrayList<>();
		n = digits.length();
		backtrack(new StringBuilder(), 0);
        return (answer);
	}



	public void backtrack(StringBuilder curr, int i) {
		if (curr.length() == n) {
			answer.add(new String(curr));
			return;
		}
		int digit = digits.charAt(i) - '0';
		String options = buttons[digit - 2];
		for (char c : options.toCharArray()) {
			curr.append(c);
			backtrack(curr, i + 1);
			curr.deleteCharAt(curr.length() - 1);
		}
	}
}

