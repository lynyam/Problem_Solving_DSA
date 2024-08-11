class Solution {
    public int halveArray(int[] nums) {
        double oldSum = 0;
        double delSum = 0;
        int step = 0;
        PriorityQueue<Double> heap = new PriorityQueue<>
            (Comparator.reverseOrder());

        for (int num : nums) {
            oldSum += num;
            heap.add(num * 1.0);
        }
        while (!heap.isEmpty() && delSum < oldSum / 2) {
            double remove = heap.remove() / 2.0;
            delSum += remove;
            heap.add(remove);
            step++;
        }
        return (step);
    }
}
/*
    - nums int[] positif
    - 1 ope choose nums[i] and make nums[i]/2
    - ret mini number ope to reduce newsum(nums[i]) <= sum(nums[i]) /2 
    newSum = oldSum - sumDelet <= oldSum / 2
    sumDelet >= oldSum/ 2
*/