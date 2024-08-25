class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> store = new HashMap<>();

        for (int num : arr) {
            store.put(num, store.getOrDefault(num, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(store.values());
        Collections.sort(values, Collections.reverseOrder());
        int ans = 0;
        int size = 0;
        for (int freq : values) {
            size += freq;
            ans++;
            if (size >= arr.length / 2)
                break ;
        }
        return (ans);
    }
}
/**
    - arr int[]
    - u can choose a set of int and remove all occ in arr
    - ret minimim size of the set so that at least half of int are removed
    -  ex : arr = [3,3,3,3,5,5,5,2,2,7] => 2

 */