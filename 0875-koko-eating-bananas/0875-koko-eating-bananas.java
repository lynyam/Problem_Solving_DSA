class Solution {
	public int minEatingSpeed(int[] piles, int h) {
		if (h <= 0) return (0);
		int n = piles.length;
		long low = 1;
		long high = 0;
		for (int pile : piles) {
			high += (long)pile;
        }
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (eatingHours(mid, piles) <= h) {
                high = mid;
            } else
                low = mid + 1;
        }       
        return ((int)low);
    }

    public int eatingHours(long mid, int[] piles) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int)Math.ceil(pile / (double)mid);
        }
        return (hours);
    }
}
