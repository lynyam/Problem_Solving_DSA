class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] answer = new int[n];
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        List<Integer> decreasing = new ArrayList<>();
        int i = 0;

        while (i < m) {
            int num = nums2[i];
            while (decreasing.size() > 0 && decreasing.get(decreasing.size() - 1) < num) {
                greaterMap.put(decreasing.remove(decreasing.size() - 1), num);
            }
            decreasing.add(num);
            i++;
        }
        i = 0;
        while (i < n) {
            answer[i] = greaterMap.getOrDefault(nums1[i], -1);
            i++;
        }
        return (answer);
    }
}