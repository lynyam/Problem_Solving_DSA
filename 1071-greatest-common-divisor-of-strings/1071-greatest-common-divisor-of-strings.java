class Solution {
	public String gcdOfStrings(String str1, String str2) {
		int n1= str1.length();
		int n2 = str2.length();
		String result = "";
		String minStr = Math.min(n1, n2) == n1 ? str1 : str2;
        int min = Math.min(n1, n2);
		
		for (int i = 1; i <= min; i++) {
            if (min % i != 0) continue ;
			String gcd = minStr.substring(0, i);
			if (check(gcd, i, str1) && check(gcd, i, str2)) 
				result = gcd;
        }	
        return (result);
    }

    public boolean check(String gcd, int len, String str) {
        if (str.length() < len || !str.startsWith(gcd))
            return (false);
        String s = str.substring(len);
        if (s.isEmpty())
            return (true);
        return (check(gcd, len, s));
    }
}


