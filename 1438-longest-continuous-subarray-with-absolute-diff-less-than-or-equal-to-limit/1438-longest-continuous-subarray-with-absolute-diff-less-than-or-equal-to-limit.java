class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        Deque<Integer> dequeMin = new LinkedList<>();
        Deque<Integer> dequeMax = new LinkedList<>();
        int ans = 0;

        while (right < n) {
            int numRight = nums[right];
            while (!dequeMin.isEmpty() && dequeMin.peekLast() > numRight) {
                dequeMin.removeLast();
            }
            while (!dequeMax.isEmpty() && dequeMax.peekLast() < numRight) {
                dequeMax.removeLast();
            }
            dequeMin.addLast(numRight);
            dequeMax.addLast(numRight);
            while (Math.abs(dequeMin.peekFirst() - dequeMax.peekFirst()) > limit) {
                if (nums[left] == dequeMin.peekFirst()) {
                    dequeMin.removeFirst();
                }
                if (nums[left] == dequeMax.peekFirst()) {
                    dequeMax.removeFirst();
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return (ans);
    }
}