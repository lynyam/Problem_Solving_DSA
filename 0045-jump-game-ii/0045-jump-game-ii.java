class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // [position, saut_count]
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int jumps = current[1];

            // Si on atteint la fin
            if (position == n - 1) {
                return jumps;
            }

            // Explorer toutes les positions atteignables depuis la position actuelle
            for (int next = position + 1; next <= Math.min(n - 1, position + nums[position]); next++) {
                if (!visited[next]) {
                    queue.offer(new int[]{next, jumps + 1});
                    visited[next] = true;
                }
            }
        }

        return -1; // Si on ne peut pas atteindre la fin
    }
}