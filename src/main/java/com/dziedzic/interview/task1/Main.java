package com.dziedzic.interview.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final String PATH_TO_INPUT = "src/main/resources/task1/input.txt";

    public static void main(String[] args) {
        var path = args.length != 0 ? args[0] : PATH_TO_INPUT;
        var list = getIntsFromFile(path);
        var numberOfElements = list.size();
        var treeSet = new TreeSet<>(list);
        printInfo(treeSet, numberOfElements);
    }

    private static void printInfo(TreeSet<Integer> treeSet, int numberOfElements) {
        var stringBuilder = new StringBuilder();
        treeSet.forEach(integer -> stringBuilder.append(integer).append(" "));
        var minValue = treeSet.size() > 0 ? treeSet.first() : null;
        var maxValue = treeSet.size() > 0 ? treeSet.last() : null;
        System.out.println(stringBuilder.toString());
        System.out.println(String.format("count: %d", numberOfElements));
        System.out.println(String.format("distinct: %d", treeSet.size()));
        System.out.println(String.format("min: %d", minValue));
        System.out.println(String.format("max: %d", maxValue));
    }

    private static List<Integer> getIntsFromFile(String path) {
        try {
            var stringFromFile = Files.readString(Paths.get(path));
            var stringArray = stringFromFile.split("\\s");
            return Arrays.stream(stringArray).map(Integer::valueOf).collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            LOGGER.info("Parsing problem occurred: " + exception.getMessage());
        } catch (IOException exception) {
            LOGGER.info("Interrupt with file: " + exception.getMessage());
        }
        return List.of();
    }
}
