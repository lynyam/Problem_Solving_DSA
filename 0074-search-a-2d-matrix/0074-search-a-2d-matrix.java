class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        //x*n + y = 6

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midx = mid / n;
            int midy = mid % n;
            if (matrix[midx][midy] == target)
                return (true);
            if (matrix[midx][midy] > target) {
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return (false);
    }
}
/**
    - matrix mxn int[]
        - row sort in nn decreasing order
        - first int row(i) > last int row(i-1)
    - target int
    - ret true if int is in matrix | false if not

    (0, 0) => 0*n + 0 = 0
    (0, 1) => 0*n + 1
    (1, 0) => 1*n + 1
 */ 