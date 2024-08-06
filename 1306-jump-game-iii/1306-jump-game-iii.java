class Solution {
    public boolean canReach(int[] arr, int start) {
        int countZeroIndex = 0;
        int n = arr.length;
        boolean[] seen = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;

        while (i < n) {
            if (arr[i] == 0)
                countZeroIndex++;
            i++;
        }
        if (countZeroIndex == 0)
            return (false);
        int temp = countZeroIndex;
        queue.add(start);
        seen[start] = true;
        while (!queue.isEmpty()) {
                int index = queue.remove();
                countZeroIndex -= arr[index] == 0 ? 1 : 0;
                int n1 = index + arr[index];
                int n2 = index - arr[index];
                if (n1 >= 0 && n1 < n && !seen[n1]) {
                    seen[n1] = true;
                    queue.add(n1);
                }
                if (n2 >= 0 && n2 < n && !seen[n2]) {
                    seen[n2] = true;
                    queue.add(n2);
                }
        }
        return (temp > countZeroIndex);

    }
}
/*
    - arr[] arr[i] >= 0 n = len
    - init start = index start
    - index i, jump to
        - i + arr[i]
        - i - arr[i]
    - check if reach any index with arr[index] = 0
    - not jump outside (isValid(index) {index >= 0 && index < n})
*/