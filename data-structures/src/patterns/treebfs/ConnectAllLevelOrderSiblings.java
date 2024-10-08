package patterns.treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllLevelOrderSiblings {
    public class Node {
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

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node previous = null;
        Node current = null;
        while(!queue.isEmpty()) {

            int size = queue.size();
            for(int i=0; i<size; i++) {
                current = queue.poll();
                if (previous != null) {
                    previous.next = current;
                }
                previous = current;

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

        }

        return root;
    }
}
