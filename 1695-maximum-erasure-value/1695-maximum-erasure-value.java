class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int i = 1;
        prefix[0] = nums[0];
        HashSet<Integer> store = new HashSet<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        

        while (i < n) {
            prefix[i] = prefix[i - 1] + nums[i];
            i++;
        }
        while (right < n) {
            int num = nums[right];
            while (store.contains(num)) {
                int numl = nums[left];
                store.remove(numl);
                left++;
            }
            store.add(num);
            ans = Math.max(ans, prefix[right] - prefix[left] + nums[left]);
            right++;
        }
        return (ans);
    }
}