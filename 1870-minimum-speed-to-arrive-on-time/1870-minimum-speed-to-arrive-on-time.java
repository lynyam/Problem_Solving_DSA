class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = (int)Math.pow(10, 7);

        if (dist.length > (int)Math.ceil(hour))
            return (-1);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, dist, hour))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return (left);
    }

    public boolean check(int speed, int[] dist, double hour) {
        double h = 0.0;
        for (int d : dist) {
            h = Math.ceil(h);
            h += d / (double)speed;
        }
        return (h <= hour);
    }
}
/**
    - hour reach office
    - n train dist[i] = ith train distance
        - each hour take minimum 1h
    -   ret minim positive int speed | -1 if not
    - max speed = 10pow7
    - v = d / t => t = d / v
        - v >  => t <
        - t > => v <
        -  t <= hour grow time => down v => right = mid - 1
 */