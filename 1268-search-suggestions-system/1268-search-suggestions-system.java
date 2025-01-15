class TrieNode {
    Map<Character, TrieNode> children;
    Set<String> common;
    TrieNode(){
        children = new HashMap<>();
        common = new HashSet<>();
    }
}

class Solution {
    TrieNode trieNode;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        trieNode = buildTrieNode(products);
        List<List<String>> ans = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            List<String> list = new ArrayList<>();
            if (trieNode.children.containsKey(c)) {
                list = new ArrayList<>(trieNode.children.get(c).common);
                Collections.sort(list);
                if (list.size() > 3) {
                    List<String> tempList = Arrays.asList(list.get(0), list.get(1), list.get(2));
                    list = tempList;
                }
                ans.add(new ArrayList<>(list));
                trieNode = trieNode.children.get(c);
            } else {
                trieNode.children = new HashMap<>();
                ans.add(new ArrayList<String>());
            }
            
        }
        return (ans);
    }

    public TrieNode buildTrieNode(String[] products) {
        TrieNode root = new TrieNode();
        for (String product : products) {
            TrieNode current = root;
            for (char c : product.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode());
                }
                current = current.children.get(c);
                current.common.add(product);
            }
        }
        return (root);
    }
}