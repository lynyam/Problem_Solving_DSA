class Solution {
    //public int maximumGap(int[] nums) {
    public int	maximumGap(int[] nums) {
		int len = nums.length;
		int max = Integer.MIN_VALUE;

		if (len <= 1)				//1 8 3 19
			return (0);
		for (int num : nums) {
			max = Math.max(max, num); //19
		}
		int expo = 1;
		int[] counting;
		int[] cumulate;
		int[] tempSort;
		int base = 10;
		while (max / expo > 0) {//[1, 3, 8, 19]//0(d * (2n + 10)) => 0 (n)// 0(n) space
            counting = new int[10];
            tempSort = new int[len];
			for (int num : nums) {
				int digit = (num / expo) % base;
				counting[digit]++; //[3,1,_ , _, _, _, _, _, _, _]
			}
			int i = 1;
			while (i < base) {
				counting[i] += counting[i - 1]; //[3, 4 , 4 , 4, 4, 4, 4, 4, 4, 4]
                //System.out.println(counting[i]);
				i++;
			}
			i = len - 1;
			while (i >= 0) {//[2, 4 , 4 , 4, 4, 4, 4, 4, 4, 3] //1 3 8 19
				int digit = (nums[i] / expo) % base;
				tempSort[counting[digit] - 1] = nums[i]; //[1, 3, 8, 19]
                //System.out.println(tempSort[counting[digit] - 1]);
				counting[digit]--;
                i--;
			}
			i = 0;
			while (i < len) {
				nums[i] = tempSort[i];//[1, 3, 8, 19]
                i++;
			}
			expo *= 10;
		}
		int i = 0;
		int maxGap = Integer.MIN_VALUE;
		while (i < len - 1) {
			maxGap = Math.max(maxGap, nums[i + 1] - nums[i]);
			i++;
		}
		return (maxGap);//11
	}

}