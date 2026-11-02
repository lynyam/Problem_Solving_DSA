class Solution {
    public String reversePrefix(String word, char ch) {
        char[] temp = word.toCharArray();
        int n = word.length();
        int start = 0;
        int target = 0;

        while (target < n) {
            if (temp[target] == ch)
                break;
            target++;
        }
        if (target == n) return new String(temp);
        while (start <= target) {
            temp[start] = word.charAt(target);
            temp[target] = word.charAt(start);
            start++;
            target--;
        }
        return new String(temp);
    }
}