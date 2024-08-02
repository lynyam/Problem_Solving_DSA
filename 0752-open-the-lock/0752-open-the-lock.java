class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int level = 0;
        
        for (String dead : deadends) {
            if (dead.equals("0000"))
                return (-1);
            seen.add(dead);
        }
        seen.add("0000");
        queue.add("0000");
        while (!queue.isEmpty()) {
            int i = 0;
            int size = queue.size();
            while (i < size) {
                String curr = queue.remove();
                if (curr.equals(target))
                    return (level);
                for (String neighbor : searchNeighbor(curr)) {
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

    public List<String> searchNeighbor(String curr) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < 4) {
            int slot = curr.charAt(i) - 48;
            int[] bound = new int[] {-1, 1};
            int j = 0;
            while (j < 2) {
                int next = (10 + slot + bound[j]) % 10;
                ans.add(curr.substring(0, i) + "" + next + curr.substring(i + 1));
                j++;
            }
            i++;
        }
        return (ans);
    }
}
/*
    - 1 lock
        - 4 wheels
            - 1 wheel 10 slots
                - 1 slot : '0' .. '9' rotate 0-1 -> 9, 9 + 1-> 0 => 10 + x -+ 1 % 10
        - init lock "0000" 
    - deadends => 4 weals stop turning
    - target = value unlock lock
    - ret : mini total nb of turn to open lock| -1  BFS
    Goal : open the lock without lock him with deadend
*/