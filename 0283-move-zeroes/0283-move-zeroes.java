class Solution {
    public void moveZeroes(int[] nums) {
        int next = 0;
        int current = 0;
        int n = nums.length;

        while (current < n) {
            int element = nums[current];
            if (element != 0) {
                if (nums[next] == 0) {
                    swap(nums, next, current);
                }
                next++;
            }
            current++;
        }
    }

    public void swap(int[] nums, int next, int current) {
        int temp = nums[next];
        nums[next] = nums[current];
        nums[current] = temp;
    }
}

// 1 3 12 0 0
// 0 |1 0 3 }12 
// 1 3 12 |3  }
// 1 3 12 0 0 
// 0 1 0 3 12
// 1 3 12 |0 0
// |2 3 4 5 0 