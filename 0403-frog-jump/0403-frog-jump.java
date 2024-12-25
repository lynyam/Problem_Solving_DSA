class Solution {
    int lastStone;
    int n;
    HashSet<Integer> stonesPosition;
    HashMap<String, Boolean> dp;
    public boolean canCross(int[] stones) {
        n = stones.length;
        dp = new HashMap<>();
        lastStone = stones[n - 1];
        stonesPosition = new HashSet<>();
        for (int stone : stones)
            stonesPosition.add(stone);
        return (helper(1, 1));
    }

    public boolean helper(int i, int k) {
        if (i < 0 || i > lastStone || !stonesPosition.contains(i) || k <= 0)
            return (false);
        if (i == lastStone)
            return (true);
        String curr = i + "#" + k;
        if (dp.containsKey(curr))
            return (dp.get(curr));
        boolean answer = helper(i + k - 1, k - 1) || helper(i + k, k) || helper(i + k + 1, k + 1);
        dp.put(curr, answer);
        return (answer);
    }
}