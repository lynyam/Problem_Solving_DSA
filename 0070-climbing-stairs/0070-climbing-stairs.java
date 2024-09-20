class Solution {
    HashMap<Integer, Integer> memo;
    public int climbStairs(int n) {
        memo = new HashMap<>();
        return (dp(n));
    }

    public  int dp(int i) {
        if (i == 1)
            return 0;
        if (i == 2)
            return 2;
        if (memo.containsKey(i))
            return (memo.get(i));
        memo.put(i, dp(i - 1) + dp(i - 2) + 1);
        return (memo.get(i));
    }
}
/**
    - Climbing staircase, take n steps to reach top
    - can ether 1 or 2 steps
    - how many distinct way can you clim to top

    SOlution:
    - return nbr of way Fn(State) 
    - recuresive formula:
        1 =>  1 Fn(1) = 1
        2 => 1 + 1 | 2 => 2 Fn(2) = Fn(1) + 1 => 2
        3 => 1 + 1 + 1 | 1 + 2 | 2 + 1 => 3 
        4 => 1 + 1 + 1 + 1| 1 + 2 + 1 | 2 + 1 + 1 | 1 + 1 + 2 => 4
        5 => 1 + 1 + 1 + 1 | 1 + 2 + 1 + 1 | 1 + 2 + 2 | 1 + 1 + 2 + 1 |  1 + 1 + 1 + 2 | 2 + 1 + 1 + 1 | 2 + 2 + 1
        2 + 1 + 2 => 4 Fn(4) + Fn(3) +  1


 */