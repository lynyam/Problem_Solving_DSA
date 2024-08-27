class Solution {
    HashMap<String, List<String>> graph;

    public void buildGraph(String bW, List<String> wL) {
        for (String w : wL) {
            if (isConnect(bW, w)) {
                graph.putIfAbsent(bW, new ArrayList<String>());
                graph.putIfAbsent(w, new ArrayList<String>());
                graph.get(bW).add(w);
                graph.get(w).add(bW);
            }
            for (String co : wL) {
                if (isConnect(w, co)) {
                    graph.putIfAbsent(w, new ArrayList<String>());
                    graph.putIfAbsent(co, new ArrayList<String>());
                    graph.get(w).add(co);
                    graph.get(co).add(w);
                }
            }
        }
    }

    public boolean isConnect(String w1, String w2) {
        int i = 0;
        int k = 1;
        int n1 = w1.length();
        if (n1 != w2.length())
            return (false);
        while (i < n1) {
            k += w1.charAt(i) != w2.charAt(i) ? -1 : 0;
            if(k < 0)
                return (false);
            i++;
        }
        return (true);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 1;
        HashSet<String> seen = new HashSet<>();
        graph = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        
        buildGraph(beginWord, wordList);
        if (!graph.containsKey(beginWord) || !graph.containsKey(endWord))
            return (0);
        queue.add(beginWord);
        seen.add(beginWord);
        while (!queue.isEmpty()) {
            int i = 0;
            int size = queue.size();
            while (i < size) {
                String node = queue.remove();
                if (node.equals(endWord)) {
                    return (level);
                }
                for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                    if (!seen.contains(neighbor)) {
                        seen.add(neighbor);
                        queue.add(neighbor);
                    }
                }
                i++;
            }
            level++;
        }
        return (0);
    }
}