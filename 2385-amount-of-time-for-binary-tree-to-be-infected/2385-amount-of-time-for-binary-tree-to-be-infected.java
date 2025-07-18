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
    int maxDepth;
    public int amountOfTime(TreeNode root, int start) {
        maxDepth = 0;
        helper(root, start);
        return (maxDepth);
    }

    public int helper(TreeNode root, int start) {
        //base case
        if (root == null) return (0);
        // il s' agit d' un pattern d'aggregation donc forcement en postOrder
        int left = helper(root.left, start);
        int right = helper(root.right, start);
        //On traite les cas qui vont se presenter.

        // - cas1: Le noeud courant est la start root.val == start.val
                //  on met a jour la variable global avec 1 + max(left, right)
                // On retourne -1 
        if (root.val == start) {
            maxDepth = Math.max(maxDepth, Math.max(left, right));
            return (-1);
        }
        // - cas2: Le noeud courant contient start dans l' un de ses substree left ou right (reconnaissable avec un restour negatif)
                // le retour de ce noeud a la root sera le minimum (left, right) -1, enfaite ca sera negatif le -1 veut dire qui' il est a 1 level de la distanc de un de ses enfant de start.
                // on aggrege maxDepth avec la sommme absolu de |left| + |right|
        else if (left < 0 || right < 0) {
            maxDepth = Math.max(maxDepth, Math.abs(left) + Math.abs(right));
            return (Math.min(left, right) -1);
        } 
        // - cas 3: Un noeud tout a fait normal comment un enfant de start ou ses counsins ou enfant de ces cousins
                // maxDepth n' est pas agreger mais on retourne 1 + max(left, right) + 1
         else {
            return (1 + Math.max(left, right));
         }
    }
}