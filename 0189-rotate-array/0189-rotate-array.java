class Solution {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        int[] extra = new int[N];
        k %= N;
        if (k== 0)
            return;
        int i = 0;
        while (i < N) {
            extra[(i + k) % N] = nums[i];
            i++;
        }

        i = 0;
        while (i < N) {
            nums[i] = extra[i];
            i++;
        }

    }
}