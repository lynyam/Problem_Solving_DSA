class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        buildStack(sb1, s);
        buildStack(sb2, t);
        return (sb1.toString().equals(sb2.toString()));

      
    }

    public void buildStack(StringBuilder sb, String s) {
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                continue ;
            }
            sb.append(c);
        }
    }
}