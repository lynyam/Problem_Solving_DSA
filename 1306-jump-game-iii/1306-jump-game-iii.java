class Solution {
    int n;
    public boolean isValid(int x) {
        return (x >= 0 && x < n);
    }

    public boolean canReach(int[] arr, int start) {
        n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[n];
        queue.add(start);
        seen[start] = true;

        while (!queue.isEmpty()) {//
            int curr = queue.remove();//5
            if (arr[curr] == 0)//1
                return (true);
            if (isValid(curr + arr[curr]) && !seen[curr + arr[curr]]) {//
                seen[curr + arr[curr]] = true;
                queue.add(curr + arr[curr]);
            }
            if (isValid(curr - arr[curr]) && !seen[curr - arr[curr]]) {
                seen[curr - arr[curr]] = true;
                queue.add(curr - arr[curr]);
            }
        }
        return (false);
    }
}
/**
    - arr 
        - arr[i] >= 0;
    - u are positioned at start index of array
    - u are index i => jump i+arr[i] or i-arr[i]
    - can u reach any index with val 0?
    - u can not jump outside
 */