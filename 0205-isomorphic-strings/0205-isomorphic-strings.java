class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> store = new HashMap<>();
		//HashSet<Character> check = new HashSet<>();
        int[] check = new int[256];
        Arrays.fill(check, 0);
		int	i = 0;
		int	n1 =  s.length();
		int	n2 = t.length();
			
		if (n1 != n2)
			return (false);
		while (i < n1) {
			char si = s.charAt(i);
			char ti = t.charAt(i);
            boolean b = store.containsKey(si);
			if ((b && store.get(si) != ti) || (!b && check[ti] > 0))
				return (false);
			if (!b) {
				store.put(si, ti); //{a:e, b:b, c:d}
				check[ti]++; //{e, b, d}
			}
			i++;
		}
		return (true);
    }
}