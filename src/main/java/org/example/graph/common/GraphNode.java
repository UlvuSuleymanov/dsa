package org.example.graph.common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphNode implements Comparable<GraphNode> {
    private final String name;
    private Integer distance = Integer.MAX_VALUE;
    private List<GraphNode> shortestPaths = new LinkedList<>();
    private Map<GraphNode, Integer> adjecentNodes = new HashMap<>();

    public GraphNode(String name) {
        this.name = name;
    }

    public void addAdjecentNode(GraphNode graphNode, Integer weight) {
        this.adjecentNodes.put(graphNode, weight);
    }


    @Override
    public int compareTo(GraphNode graphNode) {
        return Integer.compare(this.distance, graphNode.distance);
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

    public List<GraphNode> getShortestPaths() {
        return shortestPaths;
    }

    public void setShortestPaths(List<GraphNode> shortestPaths) {
        this.shortestPaths = shortestPaths;
    }

    public Map<GraphNode, Integer> getAdjecentNodes() {
        return adjecentNodes;
    }

    public void setAdjecentNodes(Map<GraphNode, Integer> adjecentNodes) {
        this.adjecentNodes = adjecentNodes;
    }
}
