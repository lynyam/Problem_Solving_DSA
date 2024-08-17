class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        Deque<Integer> dequeMax = new LinkedList<>();
        Deque<Integer> dequeMin = new LinkedList<>();


        while (right < n) {
            int numr = nums[right];
            while (!dequeMax.isEmpty() && dequeMax.peekLast() < numr) {
                dequeMax.removeLast();
            }
            while (!dequeMin.isEmpty() && dequeMin.peekLast() > numr) {
                dequeMin.removeLast();
            }
            dequeMax.add(numr);
            dequeMin.add(numr);
            while (Math.abs(numr - dequeMax.peekFirst()) > limit || Math.abs(numr - dequeMin.peekFirst()) > limit) {
                    int numl = nums[left];
                    if (numl == dequeMax.peekFirst())
                        dequeMax.removeFirst();
                    if (numl == dequeMin.peekFirst())
                        dequeMin.removeFirst();
                    left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return (ans);
    }
}
/*
    1 4 8 2 5 1.   3

    1 1-1 <=3 ans = 1 max = 1 min =1
    1 4 1-4 <= 3 ans = 2 max = 4 min =1
    1 4 8 8-1 > 3 
        DEL(1) si 1== max || min change max and min with the nex max/ min of the array
        => need to store max and min (use 2 deque monotonique inc decr) 
        max = 8 min = 4
        8-4>3
        DEL(4) min is empty as is empty 
        max = 8 min = 8


*/