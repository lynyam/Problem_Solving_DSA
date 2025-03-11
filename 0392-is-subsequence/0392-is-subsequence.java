class Solution {
	public boolean isSubsequence(String s, String t) {
		int n1 = s.length();
		int n2 = t.length();
		int i = 0;
		int j = 0;


		while (i < n1 && j < n2) {//0(n1 + n2)
			char c1 = s.charAt(i);
			char c2 = t.charAt(j);
			if (c1 == c2) {
				i++;
            }
            j++;
        }
        return (i == n1);
    }
}
