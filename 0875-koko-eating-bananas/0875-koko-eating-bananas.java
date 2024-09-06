class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;

        for (int bananas : piles) {
            right = Math.max(right, bananas);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, piles, h)) {
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return (left);
    }

    public boolean check(int mid, int[] piles, int h) {
        long hour = 0;
        for (int bans : piles) {
            hour += (long)Math.ceil(bans / (double)mid);
        }
        return (hour <= h);
    }
}
/**
    - n piles bananas
    - piles[i] = nbr banana pile ith
    - gard come in h hours
    - speed k bananas/h pile[i] < k eat all piles or eat rest after
    - ret mini k int/eat all bananas within h hours
 */