class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> store = new HashMap<>();
        List<Integer> stack = new ArrayList<>();
        int[] ans = new int[nums1.length];
        int i = 0;

        for (int num : nums2) {
            while (stack.size() > 0 && stack.get(stack.size() - 1) < num) {
                store.put(stack.remove(stack.size() - 1), num);
            }
            stack.add(num);
        }
        for (int n : nums1) {
            ans[i++] = store.getOrDefault(n, -1);
        }
        return (ans);
    }
}
/**
    - next greater elt of x in arr[]
        - First greater elt that is to right of x in same array
    - n1 n2 n1 = subset(n2)
    - find j/ n1[i]== n2[j]
    - det  the nxt greater elt of n2[j] in n2
    - if not ans[i] = -1
    - ret ans[n1] ans[i] = nxt greater elt as describe

*/