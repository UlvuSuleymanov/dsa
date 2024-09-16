package org.example.dijkstra;

import org.example.common.GraphInitializer;

import java.util.*;

public class DijkstraCalculator {

    public static void main(String[] args) {
        List<Node> graph = GraphInitializer.initializeGraphA();


        Scanner sc = new Scanner(System.in);
        System.out.println("Choose fist node:");
        final String firstNodeName = sc.nextLine();
        System.out.println("Choose last node:");
        final String lastNodeName = sc.nextLine();

        Node firstNode = graph.stream().filter(node -> node.getName().equals(firstNodeName)).findFirst().orElseThrow();
        Node lastNode = graph.stream().filter(node -> node.getName().equals(lastNodeName)).findFirst().orElseThrow();
         calculate(firstNode);
        System.out.println("The distance from "+firstNodeName+
                " to "+lastNodeName +" is " +lastNode.getDistance()+". Tha path is:");

        System.out.print(firstNode.getName()+"(0)");
        lastNode.getShortestPaths().stream().forEach(node -> {
            System.out.print("-->"+node.getName() + "(" + node.getDistance()+")");
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
            List<Node> shortestPath = new ArrayList<>(source.getShortestPaths());
            shortestPath.add(adjacentNode);
            adjacentNode.setShortestPaths(shortestPath);
        }
    }

}
