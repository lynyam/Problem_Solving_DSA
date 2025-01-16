class TrieNode {
    int common;
    HashMap<Character, TrieNode> children;
    public TrieNode() {
        children = new HashMap<>();
        common = 0;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();
        for (String str : strs) {
            if (str.isEmpty())
                return ("");
            TrieNode current = root;
            for (char c : str.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode());
                }
                current = current.children.get(c);
                current.common += 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (root.children.size() == 1) {
            for (char key : root.children.keySet()) {
                root = root.children.get(key);
                if (root.common == strs.length)
                    sb.append(key);
                else
                    break ;
            }
        }
        return (sb.toString());
    }
}