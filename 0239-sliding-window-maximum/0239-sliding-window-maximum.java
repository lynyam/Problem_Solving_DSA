class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        Deque<Integer> queue = new LinkedList<>();

        while (i < n) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (i >= k - 1) {
                answer[i - k + 1] = nums[queue.peekFirst()];
                if (queue.peekFirst() == j)
                    queue.removeFirst();
                j++;
            }
            i++;
        }
        return (answer);
    }
    /*
        3 2 -1 1 0
        [0 1 2] i = 2 j = 0 -> max = n(0) = 3
        pop j = 0  [1 2] -> [1 3] -> max = n(1) = 2
        pop j = 1 [3] -> [3, 4]-> max = n(3) = 1
    */
}