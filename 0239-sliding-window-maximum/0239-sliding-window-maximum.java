class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int right = 0;
        int left = 0;
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int i = 0;
        
        while (right < k) {
            addedQueue(deque, nums, right);
            right++;
        }
        ans[i++] = nums[deque.peekLast()];
        while (right < n) {
            int numl = nums[left];
            if (deque.peekLast() == left)
                deque.removeLast();
            left++;
            addedQueue(deque, nums, right);
            ans[i++] = nums[deque.peekLast()];
            right++;
        }
        return (ans);
    }

    public void addedQueue(Deque<Integer> deque, int[] nums,  int index) {
        int num = nums[index];
        while (!deque.isEmpty() && nums[deque.peekFirst()] < num) {
            deque.removeFirst();
        }
        deque.addFirst(index);

    }
}
/*
    - nums int []
    - int size k
    - only see k numbers in windows
    - windows moove right to one position
*/