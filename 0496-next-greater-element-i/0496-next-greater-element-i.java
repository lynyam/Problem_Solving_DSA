class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        HashMap<Integer, Integer> storeN1 = new HashMap<>();
        List<Integer> stack = new ArrayList<>();
        int[] ans = new int[n1];
        Arrays.fill(ans, -1);
        int i = 0;
        int j = 0;
        int diff;

        while (j < n1) {
            storeN1.put(nums1[j], j);
            j++;
        }
        j = 0;
        while (j < n2) {
            while (stack.size() != 0 && nums2[stack.get(stack.size() - 1)] < nums2[j]) {
                int index2 = stack.get(stack.size() - 1);
                stack.remove(stack.size() - 1);
                int index1 = storeN1.getOrDefault(nums2[index2], -1);
                if (index1 >= 0)
                    ans[index1] = nums2[j];
            }
            stack.add(j);
            j++;
        }
        return (ans);
    }
}
/*
    num2    1 2 3 2 4 5 0 6
    num1      2 3 2             RET 3 4 4
            DS : 2,0 3 => DEL(2) 3

    takw num2[0] search in num2 return diff = j 0(n) 0(1)/ 0(1) 0(n2) with HM
    while (j < num2.l) garanties that nums subset num2
        !ds.empty() && num2[ds.peek()] < nums[j] => 2 < 3
            if (ds.pop() - diff < num1l)
                ans[ds.pop() - diff] = num[j]
    ds.add(j)
    return (ans);
*/