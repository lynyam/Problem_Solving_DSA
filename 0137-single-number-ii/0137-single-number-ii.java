class Solution {
	public int singleNumber (int[] nums) {
		int result = 0;
		int bitSum = 0;
		for (int i = 0; i < 32; i++) {
			bitSum = 0;
			for (int num : nums) {
				bitSum += (num >> i) & 1;
            }
//00000010
            if (bitSum % 3 == 1) {
                result |= 1 << i;
            }
        }
        return (result);
    }
}
