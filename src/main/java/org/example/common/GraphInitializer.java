package org.example.common;

import org.example.dijkstra.Node;

import java.util.LinkedList;
import java.util.List;

public class GraphInitializer {
    public static List<Node> initializeGraphA() {
        List<Node> nodeList = new LinkedList<>();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node t = new Node("T");
        Node z = new Node("Z");

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
