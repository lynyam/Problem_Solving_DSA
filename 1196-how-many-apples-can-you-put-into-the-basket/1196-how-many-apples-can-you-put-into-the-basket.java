class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int ans = 0;
        long  sum = 0;
        for (int w : weight) {
            sum += w;
            if (sum > 5000)
                break ;
            ans++;
        }
        return (ans);
    }
}
/**
   - Somes apples, basket carry up  5000 units of weight
   -weight/ weight[i] weight of ith apple
   - ret max number of apples u can put in basket 
 */