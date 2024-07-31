class Solution {
    public String makeGood(String s) {
        int n = s.length();
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(c - stack.charAt(stack.length() - 1)) == 32) {
                stack.deleteCharAt(stack.length() - 1);
                continue ;
            }
            stack.append(c);
        }
        return (stack.toString());
    }
}