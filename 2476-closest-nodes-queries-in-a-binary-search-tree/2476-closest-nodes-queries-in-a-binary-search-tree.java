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
class Solution {
    private Set<Integer> seen = new HashSet<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nodes = new ArrayList<>();
        inOrder(root, nodes);
        for (int query : queries) {
            List<Integer> bounds = new ArrayList<>();
            /*if (seen.contains(query)) {
                bounds.add(query);
                bounds.add(query);
            } else {*/
            bounds.add(-1);
            bounds.add(-1);
            binarySearch(nodes, query, bounds);
            //searchQueryBound(root, query, bounds);
            //}
            result.add(bounds);
        }
        return (result);
    }

    public void inOrder(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        inOrder(root.left, nodes);
        nodes.add(root.val);
        inOrder(root.right, nodes);
    }

    public void binarySearch(List<Integer> nodes, int query, List<Integer> bounds) {
        int low = 0;
        int high = nodes.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nodes.get(mid) == query) {
                bounds.set(0, query);
                bounds.set(1, query);
                return;
            }
            if (nodes.get(mid) < query) {
                bounds.set(0, nodes.get(mid));
                low = mid + 1;
            } else {
                bounds.set(1, nodes.get(mid));
                high = mid - 1;
            }
        }
    }
    //0 1
    //2 4.  -> 3

    public void searchQueryBound(TreeNode root, int query, List<Integer> bounds) {
        while (root != null) {
            //seen.add(root.val);
            if (root.val == query) {
                bounds.set(0, query);
                bounds.set(1, query);
                return;
            }
            if (root.val < query) {
                bounds.set(0, root.val);
                root = root.right;
            } else {
                bounds.set(1, root.val);
                root = root.left;
            }
        }
    }

}