class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)     return 1;
        
        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
    /*int answer;
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
    }*/
}