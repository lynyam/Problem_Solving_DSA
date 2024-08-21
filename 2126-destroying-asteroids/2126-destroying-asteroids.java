class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        List<Integer> local = new ArrayList<>();
        Arrays.sort(asteroids);//3, 5, 9, 19, 21
        int i = 0;
        int n = asteroids.length;
        while (i < n) {
            int ast = asteroids[i];
            if (ast <= mass) {
                local.add(ast);//3,5,21
                i++;
                continue ;
            }
            if (!local.isEmpty()) {
                mass += local.get(local.size() - 1);//mass=38
                local.remove(local.size() - 1);//3 5
            }
            else
                return (false);
        }
        return (local.get(local.size() - 1) <= mass);
    }       
}
/**
    - mass int: planet mass original
    - asteroids int[] | asteroid[i] is mass of ith asteroid
    - u can arrage for planet collide with aster.. in arbitr.. order
        - if mass >= asteroidd[i]
            - art.. destro.. mass += aster..[i]
        - else planet destroyed
    - ret true if all asteroids can be. destroyed. | false 
 */