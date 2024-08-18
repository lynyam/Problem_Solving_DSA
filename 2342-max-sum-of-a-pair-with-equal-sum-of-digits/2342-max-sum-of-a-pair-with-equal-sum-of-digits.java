class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int i = 0;
        int n = nums.length;
        int ans = -1;

        while (i < n) {
            int num = nums[i];
            int digitSum = getDigitSum(num);
            if (store.containsKey(digitSum)) {
                int sum = num + store.get(digitSum);
                ans = ans == -1 ? sum : Math.max(ans, sum);
                store.put(digitSum, Math.max(num, store.get(digitSum)));
            } else
                store.put(digitSum, num);
            i++;
        }
        return (ans);
    }

    public int getDigitSum(int num) {
        if (num < 10) {
            return (num);
        }
        return (num % 10 + getDigitSum(num / 10));
    }
}