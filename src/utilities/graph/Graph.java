package utilities.graph;

import java.util.*;

public class Graph<T> {
    private final Map<T, Set<T>> parentShipRelation;

    public Graph(Map<T, Set<T>> parentShipRelation) {
        this.parentShipRelation = parentShipRelation;
    }

    public void addNodeAsParentOf(T desired, T parentNode) throws GraphDoesNotContainNodeException {
        if (!parentShipRelation.containsKey(desired)) throw new GraphDoesNotContainNodeException();
        else parentShipRelation.get(desired).add(parentNode);
    }

    public Collection<T> getParentsOfNode(T desired) throws GraphDoesNotContainNodeException {
        if (!parentShipRelation.containsKey(desired)) throw new GraphDoesNotContainNodeException();
        return parentShipRelation.get(desired);
    }

    public void addNode(T desired) throws NodeAlreadyExists {
        if (parentShipRelation.containsKey(desired)) throw new NodeAlreadyExists();
        parentShipRelation.put(desired, new HashSet<>());
    }

    public boolean doesGraphContainNode(T desired) {
        return parentShipRelation.containsKey(desired);
    }
}
