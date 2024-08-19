class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int n = cards.length;
        int i = 0;
        
        while (i < n) {
            int num = cards[i];
            if (store.containsKey(num)) {
                return(i - store.get(num) + 1);
            }
            store.put(num, i);
            i++;
        }
        return (-1);
        
    }
}
/**
    - cards[] int[]
        - cards[i] = value of ith card
        - cards[i] match cards[j] => cards have the same value
    - ret : minimum number of consecutive cards to pick up to have a pair of matching cards.
    - ret -1 if not
 */