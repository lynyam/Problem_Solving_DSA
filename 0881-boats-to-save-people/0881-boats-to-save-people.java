class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            ans++;
        }
        return (ans);
    }
}
/**
    - peaple array[]
        - people[i] = w of ith person
    - infinit number of boats
        - each boat can carry limit weight
        - each boat carries at most 2 peoples at same time provided sum of weight of those people it at most limit
    - ret mini number of boats to carry every given person
    - ex:
        people = [1,2], limit = 3
 */