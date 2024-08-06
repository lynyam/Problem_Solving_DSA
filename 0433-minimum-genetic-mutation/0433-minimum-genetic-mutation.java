class Solution {
    public List<String> getNeighbors(String g) {
        char[] choices = new char[] {'A', 'C', 'G', 'T'};
        int i = 0;
        List<String> ans = new ArrayList<>();
        char[] arr = g.toCharArray();

        while (i < g.length()) {
            char gi = arr[i];
            char temp = arr[i];
            for (char c : choices) {
                if (gi != c) {
                    arr[i] = c;
                    ans.add(new String(arr));
                    arr[i] = temp;
                }
            }
            i++;
        }
        return (ans);
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> seen = new HashSet<>();
        queue.add(startGene);
        seen.add(startGene);
        int i = 0;
        int n = bank.length;
        int level = 0;

        while (i < n) {
            seen.add(bank[i++]);
        }
        if (!seen.contains(endGene))
            return (-1);
        while(!queue.isEmpty()) {
            i = 0;
            int size = queue.size();
            while (i < size) {
                String node = queue.remove();
                if (node.equals(endGene)) {
                    return (level);
                }
                seen.remove(node);
                for (String neighbor : getNeighbors(node)) {
                    if (seen.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
                i++;
            }
            level++;
        }
        return (-1);
    }
}
/*
 - gene String 8 char long choice A C G T
 - mutation gene sG->eG
    - 1 mutation => 1 char change in gene
    - AACCGGTT->AACCGGTA
- gene bank record valid Gene mutatuion (isValid(gene, bank) = valid String)
- i: 2 gene sG, eG, bank
- ret: min nb of mutations needed to sG->eG | -1 if not
- sG is valid not includ in bank
*/