class Solution {
    HashMap<Integer, Integer> delMap;
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int leftSize;
    int rightSize;
    public double[] medianSlidingWindow(int[] nums, int k) {
        delMap = new HashMap<>();
        minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap = new PriorityQueue<>();
        leftSize = 0;
        rightSize = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        int i = 0;
        
        while (right < n) {
            int numr = nums[right];
            minHeap.add(numr);
            maxHeap.add(minHeap.remove());
            rightSize++;
            if (rightSize > leftSize) {
                minHeap.add(maxHeap.remove());
                leftSize++;
                rightSize--;
            }
            if (right >= k - 1) {
                updateHeap();
                ans[i++] = k % 2 == 0 ? ((double)minHeap.peek() + maxHeap.peek()) / 2.0 : minHeap.peek();
                int numl = nums[left];
                if (numl <= minHeap.peek())
                    leftSize--;
                else
                    rightSize--;
                delMap.put(numl, delMap.getOrDefault(numl, 0) + 1);
                
                left++;
            }
            right++;
        }
        return (ans);
    }

    public void updateHeap() {
        update(minHeap);
        update(maxHeap);
    }

    public void update(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty() && delMap.containsKey(heap.peek())) {
            int num = heap.peek();
            delMap.put(num, delMap.get(num) - 1);
            if (delMap.get(num) <= 0)
                delMap.remove(num);
            heap.remove();
        }
    }
}
/**
    - median = middle value in an ordered int[]
    - size % 2 == 0, median = (m1 + m2) / 2
    - nums int[]
    - int k
    - slide windows size k, 
    - ret median array for each window in original array
 */