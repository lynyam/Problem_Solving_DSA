class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int n = people.length;
        int ans = 0;

        while (i < n) {
            int wi = people[i];
            if (i + 1 < n && wi + people[i + 1] <= limit)
                i++;
            i++;
            ans++;
        }
        return (ans);
    }
}
/**
    - people[i]
    - boat carry max limit weight 2 people at same time
    - ret max nbr of boats to carry every person
 */