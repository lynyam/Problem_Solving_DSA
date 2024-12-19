class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        Deque<Integer> dequeMin = new LinkedList<>();
        Deque<Integer> dequeMax = new LinkedList<>();
        int ans = 0;
        while (right < n) {
            while(!dequeMin.isEmpty() && dequeMin.peekLast() > nums[right]) {
                dequeMin.removeLast();
            }
            dequeMin.addLast(nums[right]);
            while(!dequeMax.isEmpty() && dequeMax.peekLast() < nums[right]) {
                dequeMax.removeLast();
            }
            dequeMax.addLast(nums[right]);
            while (Math.abs(dequeMin.getFirst() - dequeMax.getFirst()) > limit) {
                if (nums[left] == dequeMin.getFirst()) {
                    dequeMin.removeFirst();
                }
                if (nums[left] == dequeMax.getFirst()) {
                    dequeMax.removeFirst();
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return (ans);
    }
    /*
        nums = [10,1,2,4,7,2], limit = 5
        l = 5
        10 i = 0 j = 0 min = 10 max = 10 ans = 1 mono deque ascendant [10(0)]
        while (num(deque.getFist) > num(i)) {
                deque.removeLast()
            }
        1 i = 0 j = 1 abs(10 - 1) > 5 
            while (abs(num(j) - num(deque.getFist))) {
                deque.removeFirst()
            }

            min = min(10, 1)-> 1
            max = max(10, 1)-> 10

    */

}