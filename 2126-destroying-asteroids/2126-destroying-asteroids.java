
class Solution {//5    1 8 2 1
	public boolean asteroidsDestroyed(int mass, int[] asteroids) {//nlog(n)
				//sort asteroids
				Arrays.sort(asteroids);//1 1 2 8 nlogn
				for (int ast : asteroids) {//0(n)
			  		if (ast > mass)
						return (false);
					mass += ast;//6 7 9
				}
				return (true);//true
			}
}
