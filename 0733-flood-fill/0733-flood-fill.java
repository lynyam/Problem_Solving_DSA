class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        helper(image, sr, sc, color);
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (image[i][j] < 0) image[i][j] = color;
            }
        }
        return (image);
    }

    public boolean isValid(int x, int y, int[][] image) {
        return (x >= 0 && x < image.length && y >= 0 && y < image[0].length);
    }
    int[][] neighbor = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public void helper(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] < 0) return;
        int currColor = image[sr][sc];
        image[sr][sc] = image[sr][sc] == 0 ? Integer.MIN_VALUE : -1 * image[sr][sc];
        
        for (int[] nei : neighbor) {
            int x = nei[0] + sr;
            int y = nei[1] + sc;
            if (isValid(x, y, image) && image[x][y] > 0 && image[x][y] == currColor) {
                helper(image, x, y, color);
            }
        }
    }
}