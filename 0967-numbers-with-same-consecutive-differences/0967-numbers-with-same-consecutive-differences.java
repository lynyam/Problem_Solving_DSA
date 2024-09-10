class Solution {
    List<Integer> ans;
    int n;

    public int[] numsSameConsecDiff(int n, int k) {
        this.n = n;
        ans = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), 0, n, k);
        int[] tab = new int[ans.size()];
        int i = 0;
        for (int num : ans) {
            tab[i++] = num;
        }
        return (tab);
    }

    public  int toNumber(List<Integer> curr) {
        int res = 0;
        for (int num : curr) {
            res = res * 10 + num;
        }
        return (res);
    }

    public void backtrack(List<Integer> curr, int i, int n, int k) {
        if (curr.size() == n) {
            ans.add(toNumber(curr));
            return ;
        }
        if (i == 0) {
            int j = 1;
            while (j <= 9) {
                curr.add(j);
                backtrack(curr, i + 1, n, k);
                curr.remove(curr.size() - 1);
                j++;
            }
        }
        else {
            int j = 0;
            while (j <= 9) {
                if (Math.abs(j - curr.get(curr.size() - 1)) == k) {
                    curr.add(j);
                    backtrack(curr, i + 1, n, k);
                    curr.remove(curr.size() - 1);
                }
                j++;
            }
        }
    }
}
/**
    - int n, k
    - ret an array of all the int of legth n
        - diff btw every 2 consecuti digit is k
        base case  i == n
                    ans.add(curr)
                if (curr.length == 0)
                    commencer par (1)
                
 */