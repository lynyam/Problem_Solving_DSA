class Solution {
    PriorityQueue<Integer> left;
    HashMap<Integer, Integer> delMap;
    PriorityQueue<Integer> right;
    int lSize;
    int rSize;
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        delMap = new HashMap<>();
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>();
        int i = 0;
        lSize = 0;
        rSize = 0;
        int j = 0;

        while (i < n) {
            int num = nums[i];
            left.add(num);
            right.add(left.remove());
            rSize++;
            if (rSize > lSize) {
                left.add(right.remove());
                rSize--;
                lSize++;
            }
            if (i >= k - 1) {
                updateHeaps();
                ans[j] = k % 2 == 1 ? left.peek() : ((long)left.peek() + right.peek()) / 2.0;
                int numl = nums[j];
                if (numl <= left.peek())
                    lSize--;
                else
                    rSize--;
                //if ()
                delMap.put(numl, delMap.getOrDefault(numl, 0) + 1);
                updateHeaps();
                j++;
            }
            i++;
        }
        return (ans);
    }

    public void updateHeaps() {
        update(left);
        update(right);   
    }
    public void update(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty() && delMap.getOrDefault(heap.peek(), 0) > 0) {
            int remove = heap.remove();
            delMap.put(remove, delMap.getOrDefault(remove, 0) - 1);
            if (delMap.get(remove) <= 0)
                delMap.remove(remove);
        }
    }
}
/**
    - median = middle val in an ordered integer list
    - size pair median is midle1 + midle2 / 2
    - nums[], k
    - sslide widow size k, see k numbers, moov one position
    - ret median array for each widows in original array
 */