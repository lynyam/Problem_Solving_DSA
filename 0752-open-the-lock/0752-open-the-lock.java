class Solution {
    public int openLock(String[] deadends, String target) {
        int level = 0;
        Queue<String>  queue = new LinkedList<>();
        queue.add("0000");
        int dead_n = deadends.length;
        HashSet<String> seen = new HashSet<>();
        int i = 0;

        while (i < dead_n) {
            seen.add(deadends[i++]);
        }
        if (seen.contains("0000"))
            return (-1);
        seen.add("0000");

        while (!queue.isEmpty()) {
            i = 0;
            int size = queue.size();
            while (i < size) {
                String curr = queue.remove();
                if (curr.equals(target)) {
                    return (level);
                }
                for (String neighbor : allConnected(curr)) {
                    if (!seen.contains(neighbor)) {
                        seen.add(neighbor);
                        queue.add(neighbor);
                    }
                }
                i++;
            }
            level++;
        }
        return (-1);
    }

    public List<String> allConnected(String curr) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        int n = curr.length();
        while (i < n) {
            char c = curr.charAt(i);
            int nbr = c - '0';
            int[] range = new int[]{-1, 1};
            for (int r : range) {
                int nei = (10 + nbr + r) % 10;
                ans.add(curr.substring(0, i) + "" + nei + curr.substring(i + 1));
            }
            i++;
        }
        return (ans);
    }


}
/*
    - 1 lock 
        - 4 weels
            - 10 slots '0'to '9' circular
                - each moov => state
    - start 0000
    - list<String> deadends
        - deadends[i]-> wheels stop turning -> open it
    - target value to unlock lock
    - ret: minimum total number of turns required to open lock, or -1 if not possible
    
*/