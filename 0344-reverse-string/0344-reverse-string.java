class Solution {
    public void reverseString(char[] s) {
        //solution1
        /* 0(n) space and 0(2n) = 0(n) time
        - recreate a temp array 0(n) space, 0(1) time
        - copy a first string in temp but in reverse order 0(n) time 0(1) space
        - recopy temp in s by override the content 0(n) time and 0(1) space
        */
        /* 0(1) space 
        - use two pointer, one on index 0 and second on index s.length - 1 at start
        - i'll use temp variable to swap the two content, because array is immutable
        - i'll use while loop to continue to do that by incrementing/decrementing the two index until they meet.
        */
        
        int i, j;
        i = 0;
        j = s.length- 1;
        
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return ;
    }
}