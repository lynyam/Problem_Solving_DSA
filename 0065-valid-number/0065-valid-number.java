class Solution {
    public boolean isNumber(String s) {
	    int n = s.length();
        int i = 0;
        int count = 0;
        
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
            if (i == n || (digitCount(s, i, n) == 0 && i < n && s.charAt(i) != '.'))
                return (false);
        }
        count = digitCount(s, i, n);
        i += count;
        if (i < n && s.charAt(i) == '.') {
            i++;
            if (digitCount(s, i, n) == 0 && count == 0)
                return (false);
        }
        i += digitCount(s, i, n);
        if ((i - 1 >= 0 && s.charAt(i - 1) != '+' && s.charAt(i - 1) != '-') && i < n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            if (i >= n || !(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                return  (false);
            i+= digitCount(s, i, n);
        }
        return (i == n);
    }


    public int digitCount(String s, int i, int n) {
        int count = 0;
        while (i < n && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
            i++;
            count++;
        }
        return (count);
    }
}