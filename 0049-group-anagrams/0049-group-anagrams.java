class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //solution 1 
        // - sort all string 0(n x mlogm)
        // - group them by comparaison n2 x m
        //      - we can use nested loop to group
        // for n string and m average size of string 
        //that give nmlogm + n2m = 0(n x m x (n + logm))

        //optimum solution reduze the nested loop by using constant lookup
        //HashMap<sortedString, List<normalString>>
        // in one past we can
            //sort -> check if exist in HM create/add to the list the normal string
            //We still have sort so 0(n x mlogm) + 0(1) lookup if we considere n string
            //so 0(n X mlogm)

        Map<String, List<String>> store = new HashMap<>();

        for (String str : strs) {
            //i will just check str sort
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String tempStr = new String(temp);
            store.putIfAbsent(tempStr, new ArrayList<String>());
            store.get(tempStr).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for(String key : store.keySet()) {
            result.add(store.get(key));
        }
        return (result);
    }
    
}