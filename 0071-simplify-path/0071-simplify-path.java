class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        int n = dirs.length;
        List<String> stack = new ArrayList<>();

        for (String dir : dirs) {
            if (stack.size() > 0 && dir.equals("..")) {
                stack.remove(stack.size() - 1);
                continue ;
            }
            if (!dir.isEmpty() && !dir.equals(".") && !dir.equals("..")) {
                stack.add(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        return (sb.isEmpty() ? "/" : sb.toString());
    }
}