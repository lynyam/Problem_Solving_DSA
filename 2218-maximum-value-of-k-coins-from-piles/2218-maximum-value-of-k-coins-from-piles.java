class State {
    int i;
    int j;
    int k;
    public State(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }
}

class Solution {
    // Max(mvc(i, j+1, k-1), (i+1, 0, k))
    List<List<Integer>> piles;
    int n;
    //HashMap<State, Integer> dp; 
    int[][] dp;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        this.piles = piles;
        n = piles.size();
        //dp = new HashMap<>();
        dp = new int[n][k + 1];
        int i = 0;
        while (i < n) {
            Arrays.fill(dp[i], -1);
            i++;
        }
        return(memo(0, k));
    }

    /*public int memo1(int i, int j, int k) {
        if (i == n || k == 0)
            return (0);
        State state = new State(i, j, k);
        if (dp.containsKey(state)) {
            return (dp.get(state));
        }
        int max = 0;
        if (j < piles.get(i).size()) {
            max =  piles.get(i).get(j) + memo(i, j + 1, k - 1);
        }
        max = Math.max(max, memo(i + 1, 0, k));
        dp.put(state, max);
        return (max);
    }
*/
      public int memo(int i, int k) {
        if (i == n || k == 0)
            return (0);
        if (dp[i][k] != -1) {
            return (dp[i][k]);
        }
        int max = memo(i + 1, k);
        int curr = 0;
        int j = 0;
        while (j < Math.min(k, piles.get(i).size())){
            curr +=  piles.get(i).get(j);
            max = Math.max(max, curr + memo(i + 1, k - j - 1));
            j++;
        }
        dp[i][k] = max;
        return (max);
    }

}