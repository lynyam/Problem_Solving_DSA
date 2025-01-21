class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        int shift = 0;
        int bitSum = 0;
        
    
        while (shift < 32) {
            bitSum = 0;
            for (int num : nums) {
                bitSum += (num >> shift) & 1;
            }
            single |= ((bitSum % 3) << shift);
            shift++;
        }
        return (single);
    }
}