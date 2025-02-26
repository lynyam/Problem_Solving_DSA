class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = matrix[j][i];
            }
            result[i] = col;
        }
        return (result);
    }
}
/*[1,2]                 [1 4 7]
  [4,5]             =>  [2 5 8]
  [7,8]
  n = 3
  m = 2
  [_ _ _]
  [_ _ _]
*/