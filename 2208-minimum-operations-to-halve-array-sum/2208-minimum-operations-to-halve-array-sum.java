class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;
        int n = nums.length;
        double sum = 0;
        double removeSum = 0;
        int step = 0;

        while (i < n) {//0(nlogn)t 0(n) z
            heap.add(nums[i] * 1.0);//0(logn)
            sum += nums[i];
            i++;
        }
        while (!heap.isEmpty() && removeSum < sum / 2.0) {//0(n)
            double remove = heap.remove() / 2.0;
            heap.add(remove); //0(logn)
            removeSum += remove;
            step++;
        }
        return (step);
    }
}
/*
    - nums int[]
    - nums[i] > 0
    - 1 ope/ choose nums[i] => nums[i] = nums[i]/2
        - u may choose this nums[i] after
    - minimum number of ope to reduce the sum of nums/at least half
*/