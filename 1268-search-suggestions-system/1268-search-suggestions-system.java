class TrieNode {
    HashMap<Character, TrieNode> children;
    List<String> names;
    public TrieNode() {
        children = new HashMap();
        names = new ArrayList<>();
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode trieNode = buildTrie(products);
        List<List<String>> answer = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            if (trieNode.children.containsKey(c)) {
                trieNode = trieNode.children.get(c);
                answer.add(trieNode.names);
            } else {
                trieNode.children = new HashMap<>();
                answer.add(new ArrayList<>());
            }
        }
        return (answer);
    }

    public TrieNode buildTrie(String[] products) {
        TrieNode root = new TrieNode();
        for (String name : products) {
            TrieNode current = root;
            for (char c : name.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode());
                }
                current = current.children.get(c);
                current.names.add(name);
                Collections.sort(current.names);
                if (current.names.size() > 3)
                    current.names.remove(current.names.size() - 1);
            }
        }
        return (root);
    }
}