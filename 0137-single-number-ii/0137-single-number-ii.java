class Solution {
    public int singleNumber(int[] nums) {
        int bitSum = 0;
        int single = 0;
        int shift = 0;
        
        while (shift < 32) {
            bitSum = 0;
            for (int num : nums) {
                bitSum += (num >> shift) & 1;
            }
            bitSum %= 3;
            single |= (bitSum << shift);
            shift++;
        }
        return (single);
    }
}