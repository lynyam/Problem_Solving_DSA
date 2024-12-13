class Solution {
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (!sb.isEmpty() && isMatch(sb.charAt(sb.length() - 1), c)) {
                sb.deleteCharAt(sb.length() - 1);
            } else 
                sb.append(c);
        }
        return (sb.length() == 0);
    }

    public boolean isMatch(char c1, char c2) {
        return ((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || 
            (c1 == '[' && c2 == ']'));
    }
}