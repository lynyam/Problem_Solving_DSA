class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        int n = dirs.length;
        Deque<String> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < n) {
            if (dirs[i].isEmpty() || dirs[i].equals(".")) {
                i++;
                continue ;
            }
            if (dirs[i].equals("..") && !deque.isEmpty()) {
                deque.removeLast();
            }
            else if (!dirs[i].equals("..")) {
                deque.add(dirs[i]);
            }
            i++;
        }
        while (!deque.isEmpty()) {
            sb.append("/");
            sb.append(deque.removeFirst());
        }
        return (sb.length() == 0 ? new String("/") : sb.toString());
    }
}