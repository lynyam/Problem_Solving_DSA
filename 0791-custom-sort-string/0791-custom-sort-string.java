class Solution {
    public String customSortString(String order, String s) {
        //first intution
        // count char and their quantitie in s with map 0(length(s)) space and time
        //looping on order and if char exist in map add it to new rebuilt s 0(length(s) + length(order)) time
        
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (counts[c - 'a'] > 0) {
                result.append(c);
                counts[c - 'a']--;
            }
        }
        for (char c : s.toCharArray()) {
            while (counts[c - 'a'] > 0) {
                result.append(c);
                counts[c - 'a']--;
            }
        }
        return result.toString();
    }
}