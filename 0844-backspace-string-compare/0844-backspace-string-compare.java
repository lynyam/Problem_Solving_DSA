class Solution {
    public boolean backspaceCompare(String s, String t) {
        return (typedString(s).equals(typedString(t)));
    }

    public String typedString(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && c == '#') {
                sb.deleteCharAt(sb.length() - 1);
                continue ;
            }
            if (c != '#')
            sb.append(c);
        }
        return (sb.toString());
    }
}