class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;
        int n = nums.length;
        double sum = 0;

        while (i < n) {
            heap.add((double)nums[i]);
            sum += nums[i];
            i++;
        }
        double halfSum = sum / 2.0;
        i = 0;
        while (!heap.isEmpty() && sum > halfSum) {
            double curr = heap.remove();
            curr /= 2.0;
            sum -= curr;
            heap.add(curr);
            i++;
        }
        return (i);    
    }
}
/**
    - nums[]
    - reduce nums[i] / 2
    - ret mini number of ope to reduce the sum of nums by at least half
 */