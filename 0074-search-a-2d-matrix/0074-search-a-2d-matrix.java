class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int n = matrix[0].length;
        int right = matrix.length * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midx = mid / n;
            int midy = mid % n;
            if (matrix[midx][midy] == target)
                return (true);
            if (matrix[midx][midy] >= target)
                right = mid - 1;
            else 
                left = mid + 1;
        }
        return (false);
    }
}
/**
    - matrix[m][n]
        - row sorted
        - 1st int of row > last int prev row
        - search target in matrix, ret true if seen or false other .. in 0(log(m*n));
 */