class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return (1);
        int answer = 10;
        int curr = 9;
        int children = 9;
        int i = 2;

        while (i <= n) {
            curr *= children;
            answer += curr;
            children--;
            i++;
        }
        return (answer);
    }
}