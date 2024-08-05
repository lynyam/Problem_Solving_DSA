class Solution {
    Map<String, List<String>> graph;

    public boolean isConnected(String s1, String s2) {
        if (s1.length() != s2.length())
            return (false);
        int k = 1;
        int i = 0;
        int n = s1.length();
        while (i < n) {
            k += s1.charAt(i) != s2.charAt(i) ? -1 : 0;
            if (k < 0)
                return (false);
            i++;
        }
        return (true);
    }

    public void buildGraph(String beginWord, List<String> worldList) {
        graph.put(beginWord, new ArrayList<>());

        for (String word : worldList) {
            if (isConnected(beginWord, word)) {
                graph.get(beginWord).add(word);
                graph.putIfAbsent(word, new ArrayList<String>());
                graph.get(word).add(beginWord);
            }
        }
        for (String from : worldList) {
            for (String to : worldList) {
                if (from.equals(to))
                    continue ;
                if (isConnected(from, to)) {
                    graph.putIfAbsent(from, new ArrayList<String>());
                    graph.putIfAbsent(to, new ArrayList<String>());
                    graph.get(from).add(to);
                    graph.get(to).add(from);
                }
            }
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        graph = new HashMap<>();
        HashSet<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int level = 1;

        buildGraph(beginWord, wordList);
        queue.add(beginWord);
        seen.add(beginWord);
        if (graph.get(beginWord).size() == 0 || !graph.containsKey(endWord))
            return (0);
        while (!queue.isEmpty()) {
            int i = 0;
            int size = queue.size();
            while (i < size) {
                String node = queue.remove();
                if (node.equals(endWord))
                    return (level);
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