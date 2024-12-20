class Solution {
    HashSet<Integer> units;
    int max;
    HashMap<String, Boolean> dp;
    public boolean canCross(int[] stones) {
        units = new HashSet<>();
        max = stones[stones.length - 1];
        dp = new HashMap<>();
        for (int stone : stones) {
            units.add(stone);
        }
        return (helper(1, 1));
    }

    public boolean helper(int i, int step) {
        if (i < 0 ||i > max || !units.contains(i) || step <= 0)
            return (false);
        if (i == max)
            return (true);
        String curr = i + "#" + step;
        if (dp.containsKey(curr))
            return (dp.get(curr));;
        boolean answer = helper(i + (step - 1), step - 1) ||
                            helper(i + (step), step) ||
                            helper(i + (step + 1), step + 1);
        dp.put(curr, answer);
        return (answer);
    }
}