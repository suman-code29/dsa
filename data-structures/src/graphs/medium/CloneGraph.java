package graphs.medium;

import graphs.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

    Map<Integer, Node> nodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (nodeMap.containsKey(node.val)) return nodeMap.get(node.val);

        Node newNode = new Node(node.val, new ArrayList<>());
        for (Node neighbours : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbours));
        }

        return newNode;
    }
}
