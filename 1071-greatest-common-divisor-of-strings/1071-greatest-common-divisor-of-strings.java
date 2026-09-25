class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) return (str1);
        if (str1.isEmpty() || str2.isEmpty()) return new String("");

        int n1 = str1.length();
        int n2 = str2.length();
        if (n1 == n2 && !str1.equals(str2)) return new String("");

        int min = n1 < n2 ? n1 : n2;
        String minStr = n1 < n2 ? str1 : str2;
        String maxStr = n1 > n2 ? str1 : str2;
        String gcd = "";
        String trygcd = "";
        int i = 0;

        while (i < min) {
            trygcd += minStr.charAt(i);
            if (isDivised(trygcd, minStr) && isDivised(trygcd, maxStr)) {
                gcd = trygcd;
            }
            i++;
        }
        return (gcd);
    }

    public boolean isDivised(String trygcd, String str) {
        String prev = trygcd;
        String pattern = trygcd;
        while (trygcd.length() <= str.length() && str.contains(trygcd)) {
            prev = trygcd;
            trygcd += pattern;
            System.out.println(trygcd);
            
        }
        return (str.equals(prev));
    }
}