class Solution {
    public String simplifyPath(String path) {
        String[] directories = path.split("/");
        List<String> canonicalPath = new ArrayList<>();

        for (String dir : directories) {
            if (canonicalPath.size() > 0 && dir.equals("..")) {
                canonicalPath.remove(canonicalPath.size() - 1);
            } else if (dir.equals("..") || dir.equals(".") || dir.isEmpty()) {
                continue;
            } else {
                canonicalPath.add(dir);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : canonicalPath) {
            result.append('/');
            result.append(dir);
        }
        return result.length() == 0 ? new String("/") : result.toString();
    }
}