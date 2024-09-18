class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 0;
        int right = (int)Math.pow(10, 7);

        if (dist.length > Math.ceil(hour)) return (-1);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, dist, hour)) {
                right = mid - 1;
            }
            else 
                left = mid + 1;
        }
        return (left);
    }

    public boolean check(int mid, int[] dist, double hour) {
        double hh = 0.0;
        for (int d : dist) {
            hh = Math.ceil(hh);
            hh += d / (double)mid;
        }
        return (hh <= hour);
    }


}
/**
    - hour  double
    - n train
    - dist[] dist[i] km of ith train
    - minimum for 1 train 1h
    - ret minimum positive int speed  to reach office | -1
    - ans max 10^7
    - v = d /t => t = d / v
    - l = 1
    - right = 10^7
    - if (dist.length > Ceil(hour))
        return (-1)
    - while (left <= right) {
        if (check(mid))
            right = mid - 1;
        else 
            left = mid + 1;
    return (left)
    }

    check(mid, dist) {
         hh = 0
         for (d:dist)
            hh = (int)hh % 1 > 0 ? (hh / 1) + 1 : hh 
            hh += d / (double)mid
        return (hh <= h)
    }
 */