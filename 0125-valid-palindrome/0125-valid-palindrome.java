class Solution {
    public boolean isPalindrome(String s) {
        //Define two valiable left 0 and right n -1
        //cL = s[left] cR = s[right]
        //if (!isValid(cL)) left++
        //else if (!isValid(cR)) right--
        // transform cl and cR in lowercase if char
        //conpare cL and cR if different return (false) else left++ right++

        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            char cl = s.charAt(left);
            char cr = s.charAt(right);
            if (!isValid(cl)) left++;
            else if (!isValid(cr)) right--;
            else if (unanimisation(cl) != unanimisation(cr)) return (false);
            else {
                left++;
                right--;
            }
        }
        return (true);
   }

   public boolean isValid(char c) {
        return ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
   }

   public int unanimisation (char c) {
        return (c >= 'A' && c <= 'Z' ? c + 32 : c);
   }
}