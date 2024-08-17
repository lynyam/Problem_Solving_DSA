class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        int n = nums.length;
        int right = 0;
        int size = 0;
        int left = 0;
        int ans = 0;

        while (right < n) {
            int numR = nums[right];
            while (!minDeque.isEmpty() && minDeque.peekLast() > numR) {
                minDeque.removeLast();
            }
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < numR) {
                maxDeque.removeLast();
            }
            minDeque.add(numR);
            maxDeque.add(numR);
            while (Math.abs(minDeque.peekFirst() - Math.abs(maxDeque.peekFirst())) > limit) {
                int numl = nums[left++];
                if (numl == minDeque.peekFirst())
                    minDeque.removeFirst();
                if (numl == maxDeque.peekFirst())
                    maxDeque.removeFirst();
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return (ans);
    }
}
/*
 8      | 4

 min: 2
 max: 8 2
[8]
min.top() - 8 = 0 <= 4
max.top() - 8 = 0 <= 4

while (numl != 2)
    min.top() - 2 = 0 <= 4
    max.top() - 8 = 6 > 4
        - l = 0, numl = 8
        - if (min.peekLast == numl) => delete
        - if (max.peekLast == numl) => delete
min:2
max:2

*/