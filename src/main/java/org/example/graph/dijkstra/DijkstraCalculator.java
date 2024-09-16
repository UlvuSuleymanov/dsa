package org.example.graph.dijkstra;

import org.example.graph.common.GraphInitializer;
import org.example.graph.common.GraphNode;

import java.util.*;

public class DijkstraCalculator {

    public static void main(String[] args) {
        List<GraphNode> graph = GraphInitializer.initializeGraphA();


        Scanner sc = new Scanner(System.in);
        System.out.println("Choose fist node:");
        final String firstNodeName = sc.nextLine();
        System.out.println("Choose last node:");
        final String lastNodeName = sc.nextLine();

        GraphNode firstGraphNode = graph.stream().filter(graphNode -> graphNode.getName().equals(firstNodeName)).findFirst().orElseThrow();
        GraphNode lastGraphNode = graph.stream().filter(graphNode -> graphNode.getName().equals(lastNodeName)).findFirst().orElseThrow();
         calculate(firstGraphNode);
        System.out.println("The distance from "+firstNodeName+
                " to "+lastNodeName +" is " + lastGraphNode.getDistance()+". Tha path is:");

        System.out.print(firstGraphNode.getName()+"(0)");
        lastGraphNode.getShortestPaths().stream().forEach(graphNode -> {
            System.out.print("-->"+ graphNode.getName() + "(" + graphNode.getDistance()+")");
        });
    }

    static void calculate(GraphNode source) {
        source.setDistance(0);
        Set<GraphNode> checkedGraphNodes = new HashSet<>();
        Queue<GraphNode> unCheckedGraphNodes = new PriorityQueue<>();
        unCheckedGraphNodes.add(source);

        while (!unCheckedGraphNodes.isEmpty()) {
            GraphNode currentGraphNode = unCheckedGraphNodes.poll();
            currentGraphNode.getAdjecentNodes()
                    .entrySet().stream()
                    .filter(node -> !checkedGraphNodes.contains(node.getKey()))
                    .forEach(node -> {
                        refreshDistance(currentGraphNode, node.getKey(), node.getValue());
                        unCheckedGraphNodes.add(node.getKey());
                    });
            checkedGraphNodes.add(currentGraphNode);
        }


    }

    static void refreshDistance(GraphNode source, GraphNode adjacentGraphNode, Integer weight) {
        Integer newDistance = source.getDistance() + weight;
        if (adjacentGraphNode.getDistance() > newDistance) {
            adjacentGraphNode.setDistance(newDistance);
            List<GraphNode> shortestPath = new ArrayList<>(source.getShortestPaths());
            shortestPath.add(adjacentGraphNode);
            adjacentGraphNode.setShortestPaths(shortestPath);
        }
    }

}
