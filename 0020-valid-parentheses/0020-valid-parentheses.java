class Solution {
    public boolean is_match(char c1, char c2) {
        return (c1 == '(' ? c2 == ')' : c1 == '{' ? c2 == '}' :
                c1 == '[' ? c2 == ']' : false);
    }
    public boolean isValid(String str) {
        List<Character> stack = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (stack.size() > 0 && is_match(stack.get(stack.size() - 1), c)) {
                stack.remove(stack.size() - 1);
                continue ;
            }
                stack.add(c); 
        }
        return (stack.size() == 0);
    }
}