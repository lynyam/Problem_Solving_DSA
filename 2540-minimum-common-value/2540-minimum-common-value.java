class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            int n1 = nums1[index1];
            int n2 = nums2[index2];
            if (n1 == n2) return (n1);
            if (n1 < n2) {
                index1++;
            } else 
                index2++;
        }
        return (-1);
    }
}
//1 4 |6 N1
//2 3 |6   N2