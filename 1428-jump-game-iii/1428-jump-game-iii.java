class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] seen = new boolean[n];
        int i = 0;
        Queue<Integer> queue = new LinkedList<>();

        
        seen[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
                int node = queue.remove();
                if (arr[node] == 0)
                    return (true);
                int n1 = node + arr[node];
                int n2 = node - arr[node];
                if (n1 < n && !seen[n1]) {
                    seen[n1] = true;
                    queue.add(n1);
                }
                if (n2 >= 0 && !seen[n2]) {
                    seen[n2] = true;
                    queue.add(n2);
                }
        }
        return (false);
    }
}
/*
    - arr int[] >= 0
    - pos start index
    - index i => jump to i + arr[i] / i - arr[i]
    - check if u can rich any index with arr[i] = 0
    - cannot jump outside
    result
    - state = i
    - edge i+arr[i] / i - arr[i]
    - senn [false, ...3=true, ...]
    - bfs
        - if valid et see

*/