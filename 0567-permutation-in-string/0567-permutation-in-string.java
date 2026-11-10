class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1, n2;
        n1 = s1.length();
        n2 = s2.length();
        if (n1 > n2) return false;//1
    //s1 = "ab", s2 = "eidbaooo"
        Map<Character, Integer> counts1 = new HashMap<>();
        Map<Character, Integer> counts2 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            counts1.put(c, counts1.getOrDefault(c, 0) + 1);//{a:1, b:1}
        }
        int i = 0;
        while (i < n1) {//n1 = 2. "eidbaooo"
            char c = s2.charAt(i);//
            counts2.put(c, counts2.getOrDefault(c, 0) + 1);//{e:1,i:1}
            i++;
        }
        // i will chech on internet if methode exist
        if (counts1.equals(counts2)) return true;
        while (i < n2) {//i = 2 n2 = 8 
            char add = s2.charAt(i);//d
            counts2.put(add, counts2.getOrDefault(add, 0) + 1);//{e:1,i:1,d:1}
            char delete = s2.charAt(i - n1);//e
            counts2.put(delete, counts2.getOrDefault(delete, 0) - 1);//pay attention copy past
            if (counts2.get(delete) == 0)
                counts2.remove(delete);
            if (counts1.equals(counts2)) return true;
            i++;
        }
        return (false);
    }
    /*
        1 - check size s1.size <= s2.size
        2 - start by the first n1 caractere of s2 
            - chekInclusion
        3 - after move one char at the time (add one char on right, delete one onleft)
            - checkInclusion

        HOw to check inclusion?
            1- the have same lenght
            solution 1 tree and compare 0(n2logn2)
            solution 2 use hashmap and compare set of key and value 0(n2) space and time


    */
}