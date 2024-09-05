class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int left = Integer.MAX_VALUE;
        int right = 0;
        int i = 0;
        int n = sweetness.length;
        long sum = 0;

        while (i < n) {
            int s = sweetness[i];
            left = Math.min(left, s);
            sum += s;
            i++;
        }
        right = (int)(sum / (k + 1));
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(mid, sweetness, k)) {
                right = mid - 1;
            }
            else
                left = mid;
        }
        return (right);
    }

    public boolean check(int mid, int[] sweet, int k) {
        int i = 0;
        int n = sweet.length;
        int sum = 0;
        int j = 0;
        int ans = 0;

        while (i < n) {
            sum = 0;
            while (j < n) {
                sum += sweet[j];
                j++;
                if (sum >= mid) {
                    ans++;
                    break ;
                }
            }
            i = j;
        }
        return (ans < k + 1);
    }
}
/**
    - chocolat bar = some chuncks
        - each chunks has its own sweetness
    - k friends k+1 part
    - eat pieces with mini total sweetness
    - cut max total sweetness for u  
    - [min, sum(sweet)/ k + 1]
    - 1
 */