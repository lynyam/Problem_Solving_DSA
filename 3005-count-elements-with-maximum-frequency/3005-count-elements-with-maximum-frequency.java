class Solution {
    public int maxFrequencyElements(int[] nums) {//[1,2,2,3,1,4]
        Map<Integer, Integer> counts = new HashMap<>();
        int maxFreq = 0;//2
        int result = 0;//4
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1); //{1:2, 2:2, 3:1, 4:1}
            int currFreq = counts.get(num);//2
            if (currFreq > maxFreq) {
                result = currFreq;
                maxFreq = currFreq;
            } else if (currFreq == maxFreq) {
                result += currFreq;
            }
        }
        return result;
    }
}