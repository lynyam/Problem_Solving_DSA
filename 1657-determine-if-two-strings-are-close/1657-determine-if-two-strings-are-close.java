class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n1, n2;
        n1 = word1.length();
        n2 = word2.length();
        boolean result = false;
        if (n1 != n2) return result;
        Map<Character, Integer> counts1 = new HashMap<>();
        Map<Character, Integer> counts2 = new HashMap<>();

        //aacabb -> bbcbaa
        for (char c : word1.toCharArray()) {
            counts1.put(c, counts1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            counts2.put(c, counts2.getOrDefault(c, 0) + 1);
        }
        //aacabb -> bbcbaa
        System.out.println(counts1);
        System.out.println(counts2);
        System.out.println(counts1.keySet().equals(counts2.keySet()));
        List<Integer> list1 = new ArrayList<>(counts1.values());
        List<Integer> list2 = new ArrayList<>(counts2.values());

        Collections.sort(list1);
        Collections.sort(list2);
        result = counts1.equals(counts2) || (
            counts1.keySet().equals(counts2.keySet())
                && list1.equals(list2)
        );
        return result;
        


    }
}
//abcde -> aecdb => check the have same char. 1) same size, 2)(K, v) and check it equal
//aacabb -> bbcbaa => 

 