class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;

        for (int  pile : piles) {
            right = Math.max(right, pile);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, piles, h))
                right = mid - 1;
            else 
                left = mid + 1;
        }
        return (left);
    }

    public boolean check(int mid, int[] piles, int h) {
        long hh = 0;
        for (int pile : piles) {
            hh += (pile / mid) + (pile % mid > 0 ? 1 : 0);
        }
        return (hh <= h);
    }
}
/**
    - n piles
        - piles ith has piles[i] bananas
    - h hours time to eats
    - speed k = nb banana/ hour
    - each hour -> k bananas on pile
        - if pile[i] < k, 1 pile / h or nb h = pile[i] / k + 1 (if pile[i] % k > 0)
    - wants to finsh banans before the gards return
    - ret minimum int k /can eat all the bananas within h hours

    Solution:
        k existe such that koko eat all banana in h hours. if speed > k solution is again good
        - use binanry search
        - left = 1 minimum speed because 0 +> koko never eat
        - right = max piles[i]. because if k > piles[i] koko eat 1 pile / hour
        check(mid) {
            for each pile
                H += Math.ceil (piles[i] / (double)k)
            return (H <= h)
        }
 */