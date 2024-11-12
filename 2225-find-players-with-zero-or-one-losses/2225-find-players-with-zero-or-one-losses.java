class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> store = new HashMap<>();

        for (int[] match : matches) {
            int win = match[0];
            int los = match[1];
            store.putIfAbsent(win, 0);
            store.put(los, store.getOrDefault(los, 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> allTWin = new ArrayList<>();
        List<Integer> oneTWin = new ArrayList<>();
        for (int key : store.keySet()) {
            if (store.get(key) == 0)
                allTWin.add(key);
            if (store.get(key) == 1)
                oneTWin.add(key);
        }
        Collections.sort(allTWin);
        Collections.sort(oneTWin);
        ans.add(allTWin);
        ans.add(oneTWin);
        return (ans);
    }
}