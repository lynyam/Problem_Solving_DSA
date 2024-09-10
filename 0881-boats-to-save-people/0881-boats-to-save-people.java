class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int ans = 0;

        while (left <= right) {
            int wei = people[left] + people[right];
            if (wei <= limit) {
                left++;
                right --;
            }
            else
                right--;
            ans++;
        }
        return (ans);
    }
}
/**
    - people[i] weight of thr ith person
    - infinite number of boats
    - each road can carry a max weight of limit.
    - each boat carries 2people maxas a same time
    - provided sum if weight of those peopele at most limit
    - ret minimuum number of boats to carry every given person 
 */