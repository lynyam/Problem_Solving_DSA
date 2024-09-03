class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int right = n * m - 1;
        //num = xm + y

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midx = mid / m;
            int midy = mid % m;
            if (matrix[midx][midy] == target)
                return (true);
            if (matrix[midx][midy] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return (false);
    }
}
/**
    matrix mxn
    return true if target is in matrix
 */