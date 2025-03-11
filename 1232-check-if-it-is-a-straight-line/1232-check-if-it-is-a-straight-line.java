class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if (n < 2) return (false);
        int[] point_a = coordinates[0];
        int[] point_b = coordinates[1];
        double deltaX = point_b[0] - point_a[0];
        double deltaY = point_b[1] - point_a[1];
        for (int i = 2; i < coordinates.length; i++) {
            point_b = coordinates[i];
            if (deltaX * (point_b[1] - point_a[1]) !=  deltaY * (point_b[0] - point_a[0]))
                return (false);
        }
        return (true);
    }
}

/*
    y = ax + b => 
    y1 = ax1 + b
    y1 - y = a(x1 - x)
    a = y1-y / x1 - x
    b = y -ax
      = y - y1-y/x1 - x

      y = ax + b
*/