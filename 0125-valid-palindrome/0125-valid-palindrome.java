class Solution {
    public boolean is_alphanumeric(char c) {
		return ((c >= 'a' && c <= 'z') ||(c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'));
}


public boolean isPalindrome(String s) {
	if (s == null || s.isEmpty()) return (true);
	int i = 0;
	int j = s.length() - 1;


	while (i < j) {
		char c1 = s.charAt(i);
		char c2 = s.charAt(j);
		if (!is_alphanumeric(c1)) {
			i++;
			continue;
}
if (!is_alphanumeric(c2)) {
	j--;
	continue ;
}
if (c1 != c2 && Math.abs(c1 - c2) != 32) return (false);
i++;
j--; 


}
return (true);
}

}