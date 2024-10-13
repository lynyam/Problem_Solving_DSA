class Solution {
    //String[] memo;
    String ans;
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return (new String());
        int n = s.length();
        /*memo = new String[n];

        Arrays.fill(memo, null);
        return (dp(n - 1, s));
    }*/

   /* public String dp(int i, String s) {
        if (i == 0) return ("" + s.charAt(0));
        if (memo[i] != null) return (memo[i]);
        String curr = s.substring(0, i);
        String next = dp(i - 1, s);
        memo[i] = isPalindrom(curr) && curr.length() > next.length() ? curr : next;
        return (memo[i]); 
    }*/
        ans = new String();
        int i = 0;
        
        while (i < n) {
            int j = 0;
            //StringBuilder sb = new StringBuilder();
            while (i + j < n) {
                if (i - j < 0 || s.charAt(i - j) != s.charAt(i + j)) {
                    break ;
                }
                j++;
            }
            String curr = s.substring(i - (j - 1), i + j);
            if(ans.length() < curr.length())
                ans = new String(curr);
            j = 1;
            while (i + j < n) {
                if (i - j + 1 < 0 || s.charAt(i - j + 1) != s.charAt(i + j)) {
                    break ;
                }
                j++;
            }
            curr = s.substring(i - j + 2, i + j);
            if(ans.length() < curr.length())
                ans = new String(curr);
            i++;
        }
        return (ans);
        //return (dp(0, new StringBuilder(), s));
    }

    /*public String dp(int i, String s) {
        if (i == s.length())
            return (new String(sub));
        
    }*/

    public boolean isPalindrom(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right))
                return (false);
            left++;
            right--;
        }
        return (true);
    }
}