package org.example.dijkstra;

import org.example.GraphInitializer;

import java.util.*;

public class DijkstraCalculator {

    public static void main(String[] args) {
        List<Node> graph = GraphInitializer.initializeGraphA();
        calculate(graph.get(0));
        graph.get(8).getShortestPaths().stream().forEach(node -> {
            System.out.println(node.getName() + " " + node.getDistance());
        });
    }

    static void calculate(Node source) {
        source.setDistance(0);
        Set<Node> checkedNodes = new HashSet<>();
        Queue<Node> unCheckedNodes = new PriorityQueue<>();
        unCheckedNodes.add(source);

        while (!unCheckedNodes.isEmpty()) {
            Node currentNode = unCheckedNodes.poll();
            currentNode.getAdjecentNodes()
                    .entrySet().stream()
                    .filter(node -> !checkedNodes.contains(node.getKey()))
                    .forEach(node -> {
                        refreshDistance(currentNode, node.getKey(), node.getValue());
                        unCheckedNodes.add(node.getKey());
                    });
            checkedNodes.add(currentNode);
        }


    }

    static void refreshDistance(Node source, Node adjacentNode, Integer weight) {
        Integer newDistance = source.getDistance() + weight;
        if (adjacentNode.getDistance() > newDistance) {
            adjacentNode.setDistance(newDistance);
            List<Node> shortestPath = source.getShortestPaths();
            shortestPath.add(adjacentNode);
            adjacentNode.setShortestPaths(shortestPath);
        }
    }

}
