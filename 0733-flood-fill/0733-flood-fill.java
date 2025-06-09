class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < n; i++) {
            if (i != sr) continue;
            for (int j = 0; j < m; j++) {
                if (j == sc) {
                    helper(image, i, j, color, image[i][j]);
                    break ;
                }
            }
        }
        return (image);
    }

    int[][] neighbors = new int[][]{
        {0, 1}, {1, 0},
        {-1, 0}, {0, -1}
    };

    public void helper(int[][] image, int i, int j, int color, int ref) {
        if (color == ref) return;
        image[i][j] = color;

        for (int[] neighbor : neighbors) {
            int x = neighbor[0] + i;
            int y = neighbor[1] + j;
            if (x >= 0 && x < image.length && y >= 0 && y < image[0].length 
                && image[x][y] == ref) {
                    helper(image, x, y, color, ref);
            }
        }
    }
}