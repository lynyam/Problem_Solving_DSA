class Solution {
    public int countElements(int[] nums) {
        HashSet<Integer> store = new HashSet<>();
        int ans = 0;

        for (int num : nums) {
            store.add(num);
        }
        for (int num : nums) {
            if (store.contains(num + 1))
                ans++;
        }
        return (ans);
    }
}