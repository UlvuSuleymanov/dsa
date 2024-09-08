package org.example.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node implements Comparable<Node> {
    private final String name;
    private Integer distance = Integer.MAX_VALUE;
    private List<Node> shortestPaths = new LinkedList<>();
    private Map<Node, Integer> adjecentNodes = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addAdjecentNode(Node node, Integer weight) {
        this.adjecentNodes.put(node, weight);
    }


    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.distance, node.distance);
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Node> getShortestPaths() {
        return shortestPaths;
    }

    public void setShortestPaths(List<Node> shortestPaths) {
        this.shortestPaths = shortestPaths;
    }

    public Map<Node, Integer> getAdjecentNodes() {
        return adjecentNodes;
    }

    public void setAdjecentNodes(Map<Node, Integer> adjecentNodes) {
        this.adjecentNodes = adjecentNodes;
    }
}
