class Solution {
    public void moveZeroes(int[] nums) {
        int next = 0;
        int current = 0;
        int n = nums.length;

        while (current < n) {
            int element = nums[current];
            if (element != 0) {
                nums[next++] = element;
            }
            current++;
        }
        while (next < n) {
            nums[next++] = 0;
        }
    }
}

// 1 3 12 0 0
// 0 |1 0 3 }12 
// 1 3 12 |3  }
// 1 3 12 0 0 