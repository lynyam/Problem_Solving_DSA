class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> store = new HashMap<>();

        for (char c : s.toCharArray()) {
            store.put(c, store.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char ci : order.toCharArray()) {
            int freq = store.getOrDefault(ci, 0);
            int i = 0;
            while (i < freq) {
                sb.append(ci);
                i++;
            }
            if (freq > 0)
                store.remove(ci);
        }
        for (char key : store.keySet()) {
            int freq = store.getOrDefault(key, 0);
            int i = 0;
            while (i < freq) {
                sb.append(key);
                i++;
            }
        }
        return (sb.toString());
    }
}
/**
    - order String
    - s String
    - order[i] unique sort in custom order
    - Permute s so that the match the order that order sorted
        - if x occure befor y in order, then x should occur before y in permuted string
    - ret any permutation of s stisted proprity
    -ex:
         order = "cba", s = "abcd" =>  "cbad"
    - Resultat
        HM<> 0(s) z t
        while (or) 0(o + s)

 */