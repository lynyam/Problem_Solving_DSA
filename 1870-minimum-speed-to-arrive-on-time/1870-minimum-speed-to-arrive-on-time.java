class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = (int)Math.pow(10, 7);
        int i = 0;

        if (dist.length > Math.ceil(hour)) {
            return (-1);
        }

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
        double h = 0;
        int i = 0;

        for (int d : dist) {
            if (i < dist.length - 1)
                h += (d % mid == 0 ? d / mid : (d / mid + 1));
            else
                h += d / (double)mid;
            i++;
        }
        return (h <= hour);
    }
}
/**
    - hour float = your time
    - n train, trains[i] = dist km for the train i
    - each train can only depart at int hour => arrondi
    - ret minimum positive int speed (km /h) | -1
    - v augmente => h diminue
    - V diminue => h augmente
    - h > 6 left = mid + 1
    - h <= 6 
 */