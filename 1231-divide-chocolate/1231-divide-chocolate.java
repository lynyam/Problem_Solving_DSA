class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int left = Integer.MAX_VALUE;
        int right = 1;
        long sum = 0;
        for (int s : sweetness) {
            left = Math.min(left, s);
            sum += s;
        }
        right = (int)(sum / (k + 1));
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(mid, sweetness, k))
                right = mid - 1;
            else
                left = mid;
        }
        return (right);
    }

    public boolean check(int mid, int[] sweets, int k) {
        int count = 0;
        long sum = 0;
        for (int sw : sweets) {
            sum += sw;
            if (sum >= mid) {
                sum = 0;
                count++;
            }
        }
        return (count < k + 1);
    }
}
/**
    - swet[i] sweet of chunck of bar
    - cutting in k+1 pieces k cuts (contigues sweet)
    - u take mini sum contigues arrays 
    - find max sum of ur part.

    - if x exist that x is a solt
        - x++ invalid solt
        - x-- solt is always good
    - we use BS
        - min solution min part
        - max = sum sweetness
    - check fonction: check if k+1 piece >= sum
        - left = mid
        else 
 */