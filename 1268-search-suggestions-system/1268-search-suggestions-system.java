class TreeNode {
    HashMap<Character, TreeNode> children;
    List<String> suggestions;
    TreeNode() {
        children = new HashMap<>();
        suggestions = new ArrayList<>();
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TreeNode root = buildTree(products);
        TreeNode node = root;
        List<List<String>> answer = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
                answer.add(node.suggestions);
            } else {
                node.children = new HashMap<>();
                answer.add(new ArrayList<String>());
            }
        }
        return (answer);
    }

    public TreeNode buildTree(String[] products) {
        TreeNode root = new TreeNode();
        for (String product : products) {
            TreeNode curr = root;
            for (char c : product.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TreeNode());
                }
                curr = curr.children.get(c);
                curr.suggestions.add(product);
                Collections.sort(curr.suggestions);
                if (curr.suggestions.size() > 3)
                    curr.suggestions.remove(curr.suggestions.size() - 1);

            }
        }
        return (root);
    }
}