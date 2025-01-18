class TrieNode {
    List<String> names;
    TrieNode[] children;
    public TrieNode() {
        names = new ArrayList<>();
        children = new TrieNode[26];
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = buildTrie(products);
        List<List<String>> answer = new ArrayList<>();

        for (char c : searchWord.toCharArray()) {
            int index = c - 'a';
            List<String> curr = new ArrayList<>();
            if (root.children[index] != null) {
                root = root.children[index];
                Collections.sort(root.names);
                curr = new ArrayList<>(root.names);
                if (root.names.size() >= 3) {
                    curr = Arrays.asList(root.names.get(0), root.names.get(1), root.names.get(2));
                }
            } else {
                root = new TrieNode();
            }
            answer.add(curr);
        }
        return (answer);
    }

    public TrieNode buildTrie(String[] products) {
        TrieNode root = new TrieNode();
        for (String name : products) {
            TrieNode current = root;
            for (char c : name.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
                current.names.add(name);
            }
        }
        return (root);
    }
}