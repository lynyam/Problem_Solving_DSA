class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        helper(image, sr, sc, color, image[sr][sc]);
        return (image);
    }

    public boolean isValid(int x, int y, int[][] image) {
        return (x >= 0 && x < image.length && y >= 0 && y < image[0].length);
    }
    int[][] neighbor = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public void helper(int[][] image, int sr, int sc, int color, int startColor) {
        if (image[sr][sc] == color) return;
        image[sr][sc] = color;
        
        for (int[] nei : neighbor) {
            int x = nei[0] + sr;
            int y = nei[1] + sc;
            if (isValid(x, y, image) && image[x][y] >= 0 && image[x][y] == startColor) {
                helper(image, x, y, color, startColor);
            }
        }
    }
}