class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> seen = new HashSet<>();
        int level = 0;
        Queue<String> queue = new LinkedList<>();

        for (String s : deadends) {
            if (s.equals("0000"))
                return (-1);
            seen.add(s);
        }
        seen.add("00000");
        queue.add("0000");
        while (!queue.isEmpty()) {
            int i = 0;
            int size = queue.size();
            while (i < size) {
                String node = queue.remove();
                if (node.equals(target))
                    return (level);
                for (String neighbor : searchedNeighbors(node)) {
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

    public List<String> searchedNeighbors(String node) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        int[] bound = new int[]{-1, 1};
        while (i < 4) {
            int num = node.charAt(i) - 48;
            int j = 0;
            while (j < 2) {
                int new_num = (num + bound[j] + 10) % 10;
                ans.add(node.substring(0, i) + String.valueOf(new_num) + node.substring(i + 1));
                j++;
            }
            i++;
        }
        return (ans);
    }
}
/*
10 - 8 = 2 = 10 - (10 - (1 + 1))
0 - 1 =>9 == 10 - (10 - (0 - 1))
    - lock
        - 4 circular wheels |0|0|0|0|
            - 10 slots: '0' '1'. ... '9'
            - wheels can rotate
            - move = turn one wheel/one slot
        - lock start |0|0|0|0|
        - String states = 0000 
    - list[State] deadends = 
        - lock_state = deadends[i] => wheels stop 
            running => will be unable to open it
    - target = wheels value unlock lock
    - ret : min total number of turn required to open lock \ -1

    node = [0000 9999] | edge = move 1 -1 to each  wheel
    if node == deadends[i]
*/