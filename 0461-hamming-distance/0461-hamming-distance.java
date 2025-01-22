class Solution {
    public int hammingDistance(int x, int y) {
        int xNory = x ^ y;
        int shift = 0;
        int distance = 0;
        while (shift < 32) {
            distance += ((xNory >> shift) & 1);
            shift++;
        }
        return (distance);
    }
}