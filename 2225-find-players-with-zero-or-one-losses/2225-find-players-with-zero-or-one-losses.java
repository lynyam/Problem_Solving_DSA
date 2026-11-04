class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losts = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> allPlayers = new HashSet<>();
        List<Integer> neverLosts = new ArrayList<>();
        List<Integer> oneLosts = new ArrayList<>();

        for (int[] match : matches) {
            losts.put(match[1], losts.getOrDefault(match[1], 0) + 1);
            allPlayers.add(match[0]);
            allPlayers.add(match[1]);
        }

        for (int player : allPlayers) {
            if (!losts.containsKey(player))
                neverLosts.add(player);
            else if (losts.get(player) == 1)
                oneLosts.add(player);
        }
        Collections.sort(neverLosts);
        Collections.sort(oneLosts);
        result.add(neverLosts);
        result.add(oneLosts);
        return (result);
    }
}