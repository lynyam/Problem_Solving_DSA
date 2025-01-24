class TrieNode {
    HashMap<String, TrieNode> children;
    boolean endOfPath;
    boolean isParent;
    String path;
    public TrieNode() {
        children = new HashMap();
    }
}

class Solution {
    List<String> answer;
    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = buildTrie(folder);
        answer = new ArrayList<>();
        helper(root);
        return (answer);
    }

    public void helper(TrieNode root) {
        if (root.endOfPath || root.isParent) {
            answer.add(root.path);
            return ;
        }
        for (String key : root.children.keySet()) {
            TrieNode node = root.children.get(key);
            helper(node);
        }
    }

    public TrieNode buildTrie(String[] folder) {
        TrieNode root = new TrieNode();
        for (String path : folder) {
            TrieNode curr = root;
            String[] dirNames = path.split("/");
            for (String name : dirNames) {
                if (!curr.children.containsKey(name)) {
                    curr.children.put(name, new TrieNode());
                } else if (curr.children.get(name).endOfPath){
                    curr.children.get(name).isParent = true;
                }
                curr = curr.children.get(name);
            }
            curr.path = path;
            curr.endOfPath = true;
        } 
        return (root);
    }
}