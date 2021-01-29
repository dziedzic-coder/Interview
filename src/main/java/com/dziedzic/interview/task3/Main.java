package com.dziedzic.interview.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final String PATH_TO_INPUT = "src/main/resources/task3/input.txt";

    public static void main(String args[]) {
        var path = args.length != 0 ? args[0] : PATH_TO_INPUT;
        var graph = new Graph();
        createVerticesFromFile(graph, path);
        System.out.print(graph.findNumberOfGraphs());
    }

    private static void createVerticesFromFile(Graph graph, String path) {
        try {
            var stringFromFile = Files.readString(Paths.get(path));
            var stringArray = stringFromFile.split("\\s");
            for (int i = 1; i < stringArray.length - 1; i++) {
                graph.addEdge(Integer.parseInt(stringArray[i]), Integer.parseInt(stringArray[++i]));
            }
        } catch (NumberFormatException exception) {
            LOGGER.info("Parsing problem occurred: " + exception.getMessage());
        } catch (IOException exception) {
            LOGGER.info("Interrupt with file: " + exception.getMessage());
        }
    }
}
