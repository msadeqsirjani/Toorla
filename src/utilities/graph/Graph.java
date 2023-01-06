package utilities.graph;

import java.util.*;

public class Graph<Node> {
    private Map<Node, Set<Node>> parentShipRelation;

    public Graph() {
        parentShipRelation = new HashMap<>();
    }

    public void addNodeAsParentOf(Node desired, Node parentNode) throws GraphDoesNotContainNodeException {
        if (!parentShipRelation.containsKey(desired)) throw new GraphDoesNotContainNodeException();
        else parentShipRelation.get(desired).add(parentNode);
    }

    public Collection<Node> getParentsOfNode(Node desired) throws GraphDoesNotContainNodeException {
        if (!parentShipRelation.containsKey(desired)) throw new GraphDoesNotContainNodeException();
        return parentShipRelation.get(desired);
    }

    public void addNode(Node desired) throws NodeAlreadyExists {
        if (parentShipRelation.containsKey(desired)) throw new NodeAlreadyExists();
        parentShipRelation.put(desired, new HashSet<>());
    }

    public boolean doesGraphContainNode(Node desired) {
        return parentShipRelation.containsKey(desired);
    }
}
