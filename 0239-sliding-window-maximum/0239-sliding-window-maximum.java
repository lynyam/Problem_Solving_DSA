class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        Deque<Integer> queue = new LinkedList<>();
        int[] ans = new int[n - k + 1];
        int j = 0;
        int l = 0;
        
        while (i < k) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
            i++;
        }
        ans[j] = queue.peekFirst();
        j++;
        while (i < n) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
            if (nums[l] == queue.peekFirst())
                queue.removeFirst();
            ans[j] = queue.peekFirst();
            l++;
            j++;
            i++;
        }
        return (ans);
    }
}