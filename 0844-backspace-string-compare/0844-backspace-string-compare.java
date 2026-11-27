class Solution {
    public boolean backspaceCompare(String s, String t) {
        return typedIntoEditor(s).equals(typedIntoEditor(t));
    }

    private String typedIntoEditor(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && c == '#') {
                sb.deleteCharAt(sb.length() - 1);
            } else if (c != '#') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}