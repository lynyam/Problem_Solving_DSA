class Solution {
    public int maximum69Number (int num) {
        String number = "" + num;
        char[] arr = number.toCharArray();
        int i = 0;
        int n = number.length();

        while (i < n) {
            if (arr[i] == '6') {
                arr[i] = '9';
                break ;
            }
            i++;
        }
        return (Integer.valueOf(new String(arr)));
        
    }
}
/**
    - num > 0
        - only. digit 6 , 9
    - ret: max number can get by changing at most one digit(6->9 and 9->6)
    - ex:
        num = 9669
        Output: 9969
 */
