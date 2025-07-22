/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return (null);
        //1-Initialisation
        //1.1 create queue 
        Queue<Node> queue = new LinkedList<>();
        //1.2 Add root on queue 
        queue.add(root);

        //2-Parcours (2 step)
        //2.1 while loop to check if level exit (2 step)
        while (!queue.isEmpty()) {
            //2.1.1 calculate size of level
            int size = queue.size();
            //2.1.2 logic on level: here problem ask to make next pointer of each level to its next right node, so create this next
            Node next = null;

            //2.2 FOR loop for walkthrough on each node of level (3 step)
            for (int i = 0; i < size; i++) {
                //2.2.1 get curr node in queue with remove
                Node node = queue.remove();
                //2.2.2 make some logic on nodes. Here it is considered to be the next precedent if it exists. The scalaire contains next
                if (next != null)
                    next.next = node;
                next = node;
                //2.2.3 add children if it exist
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return (root);
    }
}