class Solution {
    int answer;
    public int countNumbersWithUniqueDigits(int n) {
        answer = 0;
        if (n == 0)
            return (1);
        backtrack(new StringBuilder(), new HashSet<Integer>(), n);
        return (answer);
    }

    public void backtrack(StringBuilder curr, Set<Integer> check, int n) {
        if (curr.length() > n) {
            return ;
        }
        if (curr.length() > 0)
            answer++;
        //System.out.println(curr.toString());
        int i = 0;
        while (i < 10) {
            if (curr.length() == 0 || ((curr.length() > 0 && curr.charAt(0) != '0') && !check.contains(i))) {
                curr.append(i);
                check.add(i);
                backtrack(curr, check, n);
                curr.deleteCharAt(curr.length() - 1);
                check.remove(i);
            }
            i++;
        }
    }
}