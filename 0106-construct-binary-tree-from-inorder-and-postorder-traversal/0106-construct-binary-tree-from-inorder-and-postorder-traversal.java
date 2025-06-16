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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        int p = postorder.length;
        HashMap<Integer, Integer> inOrderMap = new HashMap<>();
        List<Integer> postOrderList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inOrderMap.put(inorder[i], i);
        }
        for (int i = 0; i < p; i++) {
            postOrderList.add(postorder[i]);
        }

        return (createTree(postOrderList, inOrderMap, 0, n - 1));
        
    }

    public TreeNode createTree(List<Integer> postOrder, HashMap<Integer, Integer> inOrderMap, int leftInOrder, int rightInOrder) {
        if (leftInOrder > rightInOrder) return null;
        int val = postOrder.remove(postOrder.size() - 1);
        System.out.println(val);
        TreeNode root = new TreeNode(val);
        root.right = null;
        root.left = null;
        int index = inOrderMap.get(val);
        root.right = createTree(postOrder, inOrderMap, index + 1, rightInOrder);
        root.left = createTree(postOrder, inOrderMap, leftInOrder, index - 1);
        return root;
    }
}

/**
    - InOrder
        left
        node
        right
    - PostOrder
        left
        right
        node
    root1 = postOder(lenP - 1) => 3 | 9,15,7,20 lenP -1
        3.R InOrder(3->) 15,20,7
        3.L InOrder(->3) 9
        R1.R = R2 = 3.R > 0 => R1.R = postOder(lenP - 1) = 20 => postOrder | 9,15,7
            20.R InOrder(20->) 7
            20.L InOrder(->20) 15
            R2.R = R3 = 20.R.size() > 0 => postOder(lenP - 1) = 7 => postOrder | 9,15
                7.R InOrder(7->) NULL
                7.L InOrder(->20) NULL
                R3.R = R4 = 7.R.size() > 0 Non => NULL
                R3.L = R5 = 7.L.size() > 0 Non => NULL
            R2.L = R6 = 20.L.size() > 0 => postOder(lenP - 1) = 15 => postOrder | 9
                15.R InOrder(15->) NULL
                15.L InOrder(->15) NULL
                R6.R = R7 = 15.R.size() > 0 Non => NULL
                R6.L = R8 = 15.L.size() > 0 Non => NULL
        R1.L = R9 = 3.L > 0 => R1.L = postOder(lenP - 1) = 9 => postOrder | NULL    
    


 */