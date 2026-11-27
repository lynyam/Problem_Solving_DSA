class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (stack.size() > 0 && 
            isMatch(stack.get(stack.size() - 1), c)) {
                stack.remove(stack.size() - 1);
            } else {
                stack.add(c);
            }
        }
        return stack.size() == 0;
    }

    private boolean isMatch(char left, char right) {
        return left == '[' && right == ']' ||
                left == '(' && right == ')' ||
                left == '{' && right == '}';
    }
}