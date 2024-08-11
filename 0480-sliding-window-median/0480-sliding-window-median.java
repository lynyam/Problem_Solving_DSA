class Solution {
    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;
    HashMap<Integer, Integer> markAsDelete;
    int lSize;
    int rSize;
    public double[] medianSlidingWindow(int[] nums, int k) {
       leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
       rightHeap = new PriorityQueue<>();
       lSize = 0;
       rSize = 0;
       int i = 0;
       int n = nums.length;
       double[] ans = new double[n - k + 1];
       int left = 0;
       int right = 0;
       markAsDelete = new HashMap<>();
       
        while (right < n) {
            int num = nums[right];
            leftHeap.add(num);
            rightHeap.add(leftHeap.remove());
            rSize++;
            if (rSize > lSize) {
                leftHeap.add(rightHeap.remove());
                lSize++;
                rSize--;
            }
            if (right >= k - 1) {
                balanceHeaps();
                ans[i] = k % 2 == 1 ? leftHeap.peek() : ((double)leftHeap.peek() + rightHeap.peek()) / 2.0;
                int numl = nums[left];
                if (numl <= leftHeap.peek())
                    lSize--;
                else
                    rSize--;
                markAsDelete.put(numl, markAsDelete.getOrDefault(numl, 0) + 1);
                balanceHeaps();
                left++;
                i++;
            }
            right++;
        }
        return (ans);
    }

    public void balanceHeaps() {
        while (!leftHeap.isEmpty() && markAsDelete.
            getOrDefault(leftHeap.peek(), 0) > 0) {
                    int remove = leftHeap.remove();
                    markAsDelete.put(remove, markAsDelete.
                        getOrDefault(remove, 0) - 1);
        }
        while (!rightHeap.isEmpty() && markAsDelete.getOrDefault(
                rightHeap.peek(), 0) > 0) {
                    int remove1 = rightHeap.remove();
                    markAsDelete.put(remove1, markAsDelete.
                        getOrDefault(remove1, 0) - 1);
        }
        if (lSize > rSize + 1) {
                rightHeap.add(leftHeap.remove());
                lSize--;
                rSize++;
        }
        if (rSize > lSize) {
                leftHeap.add(rightHeap.remove());
                lSize++;
                rSize--;
        }
    }
}