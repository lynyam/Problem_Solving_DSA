class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
            if ((double)dist.length > Math.ceil(hour)) return -1;
            int speed = -1;
            int left = 1;
            int right = 1;
            for (int d: dist) {
                right = Math.max(right, d);
            }
            if (right <= 1) return (1);
            if ((double)dist.length == Math.ceil(hour)) {
                right = (int)Math.ceil((right /  (hour - hour / 1)));
            }
            System.out.println(right);
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (isPossible(dist, mid, hour)) {
                    speed = mid;
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            return (speed);
    }


    public boolean isPossible(int[] dist, int mid, double hour) {
        double result = 0;
        for (int d : dist) {
            result = Math.ceil(result);
            result += (double)d / mid;
        }
        return (result <= hour);
    }
}
