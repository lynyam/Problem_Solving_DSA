class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;

        int[] merge = new int[n + m];
        int k = 0;
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) 
                merge[k] = nums1[i++];
            else
                merge[k] = nums2[j++];
            k++;
        }
        while (i < n) {
            merge[k] = nums1[i++];
            k++;
        }
        while (j < m) {
            merge[k] = nums2[j++];
            k++;
        }
        int N = n + m;
        return N % 2 == 0 ? (merge[N / 2] + merge[N / 2 - 1]) / 2.0 : merge[N / 2];
    }
}
