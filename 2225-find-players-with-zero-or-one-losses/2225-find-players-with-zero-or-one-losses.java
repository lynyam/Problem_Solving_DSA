class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> store = new HashMap<>();
        
        for (int[] match : matches) {
            int wi = match[0];
            int li = match[1];
            store.putIfAbsent(wi, 0);
            store.put(li, store.getOrDefault(li, 0) + 1);
        }
        List<Integer> winner = new ArrayList<>();
        List<Integer> looser = new ArrayList<>();
        for (int key : store.keySet()) {
            if (store.get(key).equals(0))
                winner.add(key);
            else if (store.get(key).equals(1))
                looser.add(key);
        }
        Collections.sort(winner);
        Collections.sort(looser);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(winner);
        ans.add(looser);
        return (ans);
    }
}
/**
    - matches[i] = [wi, li]
        - wi defeat li
    - ret list answer size 2:
        - answer[0] = list player that have not lost any matches
        - answer[i] = lost exactly one match
        - ret increasing order
    - player have played at leat one match
 */