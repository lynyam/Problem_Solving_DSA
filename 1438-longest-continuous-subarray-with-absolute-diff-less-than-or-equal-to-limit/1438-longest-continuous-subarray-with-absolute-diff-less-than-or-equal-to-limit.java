class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        Deque<Integer> queueMax = new LinkedList<>();
        Deque<Integer> queueMin = new LinkedList<>();

        while (right < n) {
            while (!queueMax.isEmpty() && queueMax.peekLast() < nums[right]) {
                queueMax.removeLast();
            }
            while (!queueMin.isEmpty() && queueMin.peekLast() > nums[right]) {
                queueMin.removeLast();
            }
            queueMax.add(nums[right]);
            queueMin.add(nums[right]);
            while (Math.abs(nums[right] - queueMax.peekFirst()) > limit || 
                    Math.abs(nums[right] - queueMin.peekFirst()) > limit) {
                    int numl = nums[left];
                    if (numl == queueMax.peekFirst())
                        queueMax.removeFirst();
                    if (numl == queueMin.peekFirst())
                        queueMin.removeFirst();
                    left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return (ans);
    }
}
/*
    8 2 4 7.     4
    int l, r
    r = 0 | 8 max = 8 min=8 | 8
        8 - 8 <= 4 && 8 - 8 <= 4
        ans = r-l+1 = 1
    r = 1 | 2 max = 8 min = 8 |maxq(dec) = 8->2 minq(incr) = 2
        max - 2 && min - 2 > 4 max = 8 min = 2
            l++ | l= 1
        2-2 <= 4 && 2-2 <=4 max = 2 min = 2 |2-> 2->
    r = 2 | 4 maxq(dec) 4-> minq(incr)2->4
        4-4<=4 4-2<= 4 =>[2 4] ans = max(ans, 2 - 1 + 1) = 2
    r = 3 | 7 maxq(dec) ->7 minq(incr)2->4->7
        7-7<=4 2-7>=4 [2 4 7]
            7-7<=4 2-7>=4
                l = 1 =>2==top minq(incr)2->4->7=> 4->7
                l++
            7 - 7<= 4 7-3 <= 4 l = 2
            ans = (3-2 + 1) = 2


*/