class Solution {
    int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        if (k <= 0) return new int[0];
        int i = 0;


        for (i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {//3?-1
                deque.removeLast();
            }
            deque.addLast(i);//1(3), 2(-1)
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = nums[deque.peekFirst()];//3
        int l = 1;
        while (i < n) {//7(7)
            int num = nums[i];//6
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= num) {
                        deque.removeLast();
            }
            deque.addLast(i);// 7(7)
            result[l++] = nums[deque.peekFirst()]; //3 3 5 5 6 7
            i++;
        }
        return (result);
    }   
}