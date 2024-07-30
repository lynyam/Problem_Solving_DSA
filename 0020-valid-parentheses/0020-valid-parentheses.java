class Solution {

    public boolean isMatch(char open, char close) {
        return (open == '(' ? close == ')' : open == '{' ? close == '}' :
            open == '[' ? close ==']' : false);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.empty() || !isMatch(stack.peek(), c)) {
                return (false);
            } else
                stack.pop();
        }
        return (stack.empty());
    }
}