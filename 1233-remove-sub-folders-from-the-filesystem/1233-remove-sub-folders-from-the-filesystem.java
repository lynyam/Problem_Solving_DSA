class TreeNode {
    HashMap<String, TreeNode> children;
    boolean isParent;
    boolean endOfPath;
    String path;
    public TreeNode() {
        children = new HashMap<>();
        path = null;
        isParent = true;
    }
}

class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> removeSubfolders(String[] folder) {
        TreeNode root = buildTrie(folder);
        helper(root);
        return (answer);
    }

    public void helper(TreeNode root) {
        if ((root.endOfPath && root.isParent) || root.endOfPath && root.children.size() != 0) {
            answer.add(new String(root.path));
            return ;
        }
        for (String key : root.children.keySet()) {
            TreeNode node = root.children.get(key);
            helper(node);
        }
    }

    public TreeNode buildTrie(String[] folder) {
        TreeNode root = new TreeNode();
        for (String path : folder) {
            TreeNode curr = root;
            String[] names = path.split("/");
            boolean isParent = false;
            for (String name : names) {
                if (!curr.children.containsKey(name)) {
                    curr.children.put(name, new TreeNode());
                    isParent = true;  
                }
                curr = curr.children.get(name);
            }
            curr.endOfPath = true;
            curr.isParent = isParent;
            curr.path = path;
        }
        return (root);
    }
}