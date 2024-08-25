class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int ans = 0;
        int i = 0;
        int n = weight.length;

        while (i < n) {
            ans += weight[i];
            if(ans > 5000)
                return (i);
            i++;
        }
        return (i);
    }
}
/**
    - apples
    - basket carry up 5000 unit of weight
    - weight int[]
        - weight[i] = weight ith apple
    - ret max number of apples u can put in basket
 */