class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int max = 0;
        
        for (int num : nums) {
            store.put(num, store.getOrDefault(num, 0) + 1);
            max = Math.max(max, store.get(num));
        }
        List<List<Integer>> bucket = new ArrayList<>();
        int i = 0;
        while (i <= max) {
            bucket.add(new ArrayList<Integer>());
            i++;
        }
        for (int key : store.keySet()) {
            bucket.get(store.get(key)).add(key);
        }
        int[] topK = new int[k];
        i = max;
        int j = 0;
        while (i >= 0 && j < k) {
            List<Integer> list = bucket.get(i);
            for (int topi : list) {
                if (j < k) {
                    topK[j] = topi;
                    j++;
                }
                else
                    break ;
            }
            i--;
        }
        return (topK);
    }
}
/**
    - nums int[]
    - k int
    - ret: k most frequent elts
    - ret ans in any order
 */