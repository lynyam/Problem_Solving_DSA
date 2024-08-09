class Solution {
    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;
    HashMap<Integer, Integer> deleteMap;
    int lSize;
    int rSize;
    public double[] medianSlidingWindow(int[] nums, int k) {
        leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
        rightHeap = new PriorityQueue<>();
        deleteMap = new HashMap<>();
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        int right = 0;
        int left = 0;
        int i = 0;
        lSize = 0;
        rSize = 0;

        while (right < n) {
            int num = nums[right];
            leftHeap.add(num);
            rightHeap.add(leftHeap.remove());
            rSize++;
            if (rSize > lSize) {
                leftHeap.add(rightHeap.remove());
                rSize--;
                lSize++;
            }
            if (right >= k - 1) {
                removeLeft();
                ans[i] = k % 2 == 1 ? leftHeap.peek() : ((double)rightHeap.peek() + leftHeap.peek()) / 2.0;
                int numl = nums[left];
                if (numl <= leftHeap.peek())
                    lSize--;
                else
                    rSize--;
                deleteMap.put(numl, deleteMap.getOrDefault(numl, 0) + 1);
                removeLeft();
                left++;
                i++;
            }
            right++;
        }
        return (ans);
    }

    public void removeLeft() {
        while (!leftHeap.isEmpty() && deleteMap.getOrDefault(leftHeap.peek(), 0) > 0) {
            int num = leftHeap.remove();
            deleteMap.put(num, deleteMap.getOrDefault(num, 0) - 1);
        }
        while (!rightHeap.isEmpty () && deleteMap.getOrDefault(rightHeap.peek(), 0) > 0) {
            int num2 = rightHeap.remove();
            deleteMap.put(num2, deleteMap.getOrDefault(num2, 0) - 1);
        }
        if (lSize > rSize + 1) {
            rightHeap.add(leftHeap.remove());
            rSize++;
            lSize--;
        }
        if (rSize > lSize) {
            leftHeap.add(rightHeap.remove());
            rSize--;
            lSize++;
        }
    }
}
/*
    - median = middle val List<Int> ordered
    - list.size() = even, median of two middle val
    - nums[] int[]
    - int k
    - slide wiindow size k moove left to right
    - only see k number in windows
    - each time moove right by one position
    - ret median arra for each window in orginal array
*/