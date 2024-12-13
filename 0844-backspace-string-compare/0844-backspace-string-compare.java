class Solution {
    public boolean backspaceCompare(String s, String t) {
        return (backspace(s).equals(backspace(t)));
    }

    public String backspace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!sb.isEmpty() && c == '#') {
                sb.deleteCharAt(sb.length() - 1);
            } else if (c != '#') {
                sb.append(c);
            }
        }
        return (sb.toString());
    }
}