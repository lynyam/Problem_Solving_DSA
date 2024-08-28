class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //Arrays.sort(piles);
        int n = piles.length;
        int left = 1;
        int right = 0;
        for (int bananas: piles) {
            right = Math.max(right, bananas);
        }
        //int right = piles[n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(piles, mid) <= h) {
                right = mid;
            }
            else
                left = mid + 1;
        }
        return (left);
    }

    public int check(int[] piles, int mid) {
        int ans = 0;
        int i = 0;
        while (i < piles.length) {
            int pile = piles[i];
            ans += pile % mid == 0 ? pile / mid : (pile / mid) + 1;
            i++;
        }
        return (ans);
    }
}
/**
    - n piles bananas
    - piles int[] ith pile has piles[i] 
    - h hours
    - k bananas/hour speed
    - if pils[i] <= k eat all of them and not eat other bananas in this hour
    - eat all bananas befor guards come
    - ret minimum k/ eat all bananas in h hours
    - ex: piles = [3,6,7,11], h = 8 => 4
 */