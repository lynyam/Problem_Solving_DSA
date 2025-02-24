class TreeNode {
    boolean file;
    String content;
    HashMap<String, TreeNode> children;
    public TreeNode(boolean f) {
        file = f;
        content = "";
        children = new HashMap<>();
    }
}
class FileSystem {
    TreeNode root;
    public FileSystem() {
        root = new TreeNode(false);
    }
    
    public List<String> ls(String path) {
        if (path.isEmpty()) {return (new ArrayList<>());}
        if (path.equals("/")) {
            List<String> rootList = new ArrayList<>(root.children.keySet());
            Collections.sort(rootList);
            return rootList;
        }
        String[] paths = path.substring(1).split("/");
        List<String> answer = new ArrayList<>();
        TreeNode curr = root;
        String currPath = "";
        for (String subpath : paths) {
            if (!curr.children.containsKey(subpath)) return (answer);
            curr = curr.children.get(subpath);
            currPath = subpath;
        }
        if (curr.file)
            answer.add(currPath);
        else {
            answer.addAll(curr.children.keySet());
            Collections.sort(answer);
        }
        return (answer);
    }
    
    public void mkdir(String path) {
        mkAndGetNode(path);
    }
    
    public TreeNode mkAndGetNode(String path) {
        if (path.isEmpty()) return null;
        if (path.equals("/")) return root;
        String[] paths = path.substring(1).split("/");
        TreeNode curr = root;
        for (String subpath : paths) {
            curr.children.putIfAbsent(subpath, new TreeNode(false));
            curr = curr.children.get(subpath);
        }
        return (curr);
    }
    public void addContentToFile(String filePath, String content) {
        TreeNode lastNode = mkAndGetNode(filePath);
        lastNode.file = true;
        lastNode.content += content; 
    }
    
    public String readContentFromFile(String filePath) {
        return (mkAndGetNode(filePath).content);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */