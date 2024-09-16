package org.example.graph.common;

import java.util.LinkedList;
import java.util.List;

public class GraphInitializer {
    public static List<GraphNode> initializeGraphA() {
        List<GraphNode> graphNodeList = new LinkedList<>();
        GraphNode a = new GraphNode("A");
        GraphNode b = new GraphNode("B");
        GraphNode c = new GraphNode("C");
        GraphNode d = new GraphNode("D");
        GraphNode f = new GraphNode("F");
        GraphNode g = new GraphNode("G");
        GraphNode h = new GraphNode("H");
        GraphNode t = new GraphNode("T");
        GraphNode z = new GraphNode("Z");

        a.addAdjecentNode(c, 16);
        a.addAdjecentNode(b, 9);
        b.addAdjecentNode(f, 8);
        b.addAdjecentNode(d, 8);
        c.addAdjecentNode(g, 20);
        d.addAdjecentNode(h, 11);
        f.addAdjecentNode(g, 16);
        f.addAdjecentNode(h, 9);
        g.addAdjecentNode(t, 9);
        h.addAdjecentNode(z, 12);
        t.addAdjecentNode(z, 14);

        return List.of(a, b, c, d, f, g, h, t, z);

    }
}
