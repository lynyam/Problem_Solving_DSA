/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {
    TreeNode root;
    Queue<TreeNode> parents;

    public CBTInserter(TreeNode root) {
        this.root = root;
        parents = new LinkedList<>();
        List<List<TreeNode>> levelOrder = new ArrayList<>();
        levelTraversal(root, 0, levelOrder);
        fillQueue(parents, levelOrder);
    }

    public void levelTraversal(TreeNode root, int depth, List<List<TreeNode>> levelOrder) {
        if (root == null) return ;
        if (levelOrder.size() <= depth)
            levelOrder.add(new ArrayList<>());
        levelOrder.get(depth).add(root);
        levelTraversal(root.left, depth + 1, levelOrder);
        levelTraversal(root.right, depth + 1, levelOrder);
    }

    public void fillQueue(Queue<TreeNode> parents, List<List<TreeNode>> levelOrder) {
        for (List<TreeNode> level : levelOrder) {
            for (TreeNode node : level) {
                //System.out.println("node.val = " + node.val);
                parents.add(node);
            }
        }
    }

    public int insert(int val) {
        while (!parents.isEmpty() && parents.peek().left != null && parents.peek().right != null) {
            parents.poll();
        }
        TreeNode newNode = new TreeNode(val);
        TreeNode parent = parents.peek();
        //System.out.println("parent.val = " + parent.val);
        if (parent.left == null)
            parent.left = newNode;
        else
            parent.right = newNode;
        parents.add(newNode);
        return (parent.val);
    }

    public TreeNode get_root() {
        return (root);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */