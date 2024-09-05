class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length > (int)Math.ceil(hour))
            return (-1);
        int left = 1;
        int right = (int)Math.pow(10, 7);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, dist, hour))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return (left);
    }

    public boolean check(int mid, int[] dist, double hour) {
        double reelHour = 0.0;
        
        for (int d : dist) {
            reelHour = Math.ceil(reelHour);
            reelHour += d / (double)mid;
        }
        return (reelHour <= hour);
    }
}
/**
    - hour, float
    - take n train
    - dist[] of length n dist[i] distance of ith train
    - each train take mini 1h
    - ret mini positiv int speed or -1 if it impossible
    -  ans max = 10exp7
    - v =. d / t => t = d / v
    - v augmente heure diminue et inversement
 */