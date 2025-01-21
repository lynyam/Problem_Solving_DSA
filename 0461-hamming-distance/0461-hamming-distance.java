class Solution {
    public int hammingDistance(int x, int y) {
        int diff = x ^ y;
        int i = 0;
        int a = 0;
        while (i < 32) {
            if (((diff >> i) & 1) == 1) {
                a++;
            }
            i++;
        }
        return (a);
    }
}