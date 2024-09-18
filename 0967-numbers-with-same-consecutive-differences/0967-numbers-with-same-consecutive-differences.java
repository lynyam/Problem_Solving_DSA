class Solution {
    List<Integer> ans;
    public int[] numsSameConsecDiff(int n, int k) {
        ans = new ArrayList<>();
        backtrack(0, 0, n, k);
        int[] res = new int[ans.size()];
        int i = 0;
        for (int num : ans) {
            res[i++] = num;
        }
        return (res);
    }

    public void backtrack(int curr, int size, int n, int k) {
        if (size == n) {
            ans.add(curr);
            return ;
        }
        int i = 0;
        while (i <= 9) {
            if (size == 0 || (curr != 0 && Math.abs((curr % 10) - i) == k)) {
                size++;
                curr = curr * 10 + i;
                backtrack(curr, size, n, k);
                curr /= 10;
                size--;
            }
            i++;
        }
    }
}
/**
    - n, k integer
    - array of all int of length n where diff(every cons digit) = k
    - 02 and 043 not good int
    Solution : 
        tail n 
        digit = 0123456789
        contraint last_digit - new_digit = k

        base case = curr.size() == n ans.add(listToInt(curr)) //0(n) t
        loop on 0 to 9
            if (curr is empty) //10 x 10/k (10/k)
                curr.add()
            else if (curr.size() == 1 && curr.last != 0 && curr.last - digit == k)
                    curr.add(curr)
 */