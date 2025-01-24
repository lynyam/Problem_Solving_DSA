class TrieNode {
    List<String> words;
    Map<Character, TrieNode> children;

    public TrieNode() {
        words = new ArrayList<>();
        children = new HashMap<>();
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = buildTrie(products);
        List<List<String>> answer = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            if (root.children.containsKey(c)) {
                root = root.children.get(c);
                Collections.sort(root.words);
                List<String> words = root.words;
                if (words.size() > 3) {
                    words = Arrays.asList(root.words.get(0), root.words.get(1), root.words.get(2));
                }
                answer.add(words);
            }
            else {
                root = new TrieNode();
                answer.add(new ArrayList<>());
            }
        }
        return (answer);
    }

    public TrieNode buildTrie(String[] products) {
        TrieNode root = new TrieNode();

        for (String product : products) {
            TrieNode curr = root;
            for (char c : product.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
                curr.words.add(product);
            }
        }
        return (root);
    }
}