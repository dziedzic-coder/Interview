package com.dziedzic.interview.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class Graph {

    private final Map<Integer, ArrayList<Integer>> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public void addEdge(int firstVertex, int secondVertex) {
        if (!vertices.containsKey(firstVertex)) {
            vertices.put(firstVertex, new ArrayList<>());
        }
        if (!vertices.containsKey(secondVertex)) {
            vertices.put(secondVertex, new ArrayList<>());
        }
        vertices.get(firstVertex).add(secondVertex);
        vertices.get(secondVertex).add(firstVertex);
    }

    public int findNumberOfGraphs() {
        var numberOfGraphs = new AtomicInteger(0);
        var visited = new Stack<Integer>();
        vertices.forEach((vertex, setOfVertices) -> {
            if (!visited.contains(vertex)) {
                dfs(vertex, visited);
                numberOfGraphs.getAndIncrement();
            }
        });

        return numberOfGraphs.get();
    }

    private void dfs(int startingVertex, Stack<Integer> visited) {
        var stackToVisit = new Stack<Integer>();
        stackToVisit.push(startingVertex);
        while (!stackToVisit.isEmpty()) {
            var currentVertex = stackToVisit.pop();
            visited.push(currentVertex);
            if (vertices.containsKey(currentVertex)) {
                vertices.get(currentVertex).forEach(vertex -> {
                    if (!visited.contains(vertex))
                        stackToVisit.push(vertex);
                });
            }
        }
    }
}
