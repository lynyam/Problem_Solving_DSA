class Solution {
    public boolean closeStrings(String word1, String word2) {//0(n1 + n2 + k1 + k1logk1 + k2 + k2logk2) t  = 0(n1 + n2 +k1logk1 + k2logk2)//0(n1 + n2 + k1+k2) z
        HashMap<Character, Integer> store1 = new HashMap<>();//0(n) z
        HashMap<Character, Integer> store2 = new HashMap<>();//0(n2) z
        if (word1.length() != word2.length())
            return (false);

        for (char c : word1.toCharArray()) { //0(n1) t
            store1.put(c, store1.getOrDefault(c, 0) + 1);
        }
        for (char c1 : word2.toCharArray()) { //0(n2) t
            store2.put(c1, store2.getOrDefault(c1, 0) + 1);
        }
        List list1  = new ArrayList<Integer>(store1.values()); //0(k1) t z
        List list2 = new ArrayList<Integer>(store2.values());// 0(k2) tz
        Collections.sort(list1); //0(k1logk1) t
        Collections.sort(list2); //0(k2logk2) t
        if (!list1.equals(list2))
            return (false);
        return(store1.keySet().equals(store2.keySet()));
    }
}