class TrieNode {
    int common;
    TrieNode[] children;
    char c;
    public TrieNode() {
        children = new TrieNode[26];
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();
        for (String str : strs) {
            TrieNode current = root;
            for (char c : str.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                }
                current = current.children[c - 'a'];
                current.common += 1;
                current.c = c;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (root != null) {
            char c = 0;
            for (TrieNode node : root.children) {
                if (node != null && node.common == strs.length) {
                    c = node.c;
                    root = node;
                }
            }
            if (c != 0)
                sb.append(c);
            else 
                return (sb.toString());
        }
        return (sb.toString());
    }
}