class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int i = 0;
        int n = asteroids.length;
        long masses = mass;

        while (i < n) {
            if (masses < asteroids[i])
                return (false);
            masses += asteroids[i];
            i++;
        }
        return (true);
    }
}
/**
    - mass planet
    - asteroid[n] mass of asteroid
    - if mass >= mass asteroid mass += mass asteroid
 */