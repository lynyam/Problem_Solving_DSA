class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);//1 2 2 3 3
        int i = 0;
        int res = 0;
        int n = people.length;
        int j = n - 1;
        while (i <= j) {
            int sum = people[i] + people[j];
            if (sum <= limit) {
                i++;
            }
            j--;
            res++;
        }
        return (res);
    }
}