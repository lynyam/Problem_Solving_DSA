class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int index_s = 0;
        int index_space = 0;
	
        while (index_s < s.length()) {
            if (index_space < spaces.length && index_s == spaces[index_space]) {
                result.append(" ");
                index_space++;
            }       
            result.append(s.charAt(index_s++));
        }
        return (result.toString());
    }
}