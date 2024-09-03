class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        int i = 0;
        Arrays.sort(potions);

        while (i < n) {
            int left = 0;
            int right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if ((long)potions[mid] * spells[i] >= success)
                    right = mid - 1;
                else 
                    left = mid + 1;
            }
            ans[i] = m - left;
            i++;
        }
        return (ans);
    }
}
/**
    - spells/potions
    - [spell[i]* potions[i]] >= succes => pair
    - pairs[i] = number of potions that will form successful pair with ith spell
 */