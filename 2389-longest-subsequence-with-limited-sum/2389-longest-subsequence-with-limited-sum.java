class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] prefix = new int[n];
        int i = 1;
        int m = queries.length;
        int[] ans = new int[m];

        prefix[0] = nums[0];
        while (i < n) {
            prefix[i] = prefix[i - 1] + nums[i];
            i++;
        }
        i = 0;
        while (i < m) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {//1 3 7 12
                int mid = left + (right - left) / 2;//1->3
                if (prefix[mid] > queries[i])//3=3 \ 1 ?3
                    right = mid - 1;//right = 1-1 = 0/ 0
                else //1<3
                    left = mid + 1;//0/1
            }
            ans[i] = left;
            i++;
        }
        return (ans);
    }
}
/**
    - nums int[] n
    - queries int[] m
    - ret ans int[] m
        - ans[i] is max size of subsequence that u can take from num
            - sum of its elts <= queries[i]
    -  nums = [4,5,2,1], queries = [3,10,21] => [2 3 4]
 */