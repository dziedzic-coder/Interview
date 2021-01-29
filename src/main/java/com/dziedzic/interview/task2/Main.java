package com.dziedzic.interview.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final String PATH_TO_INPUT = "src/main/resources/task2/input.txt";
    private static final int DESIRED_PAIR_SUM = 13;

    public static void main(String[] args) {
        var path = args.length != 0 ? args[0] : PATH_TO_INPUT;
        var finder = new PairFinder();
        var array = getIntsArrayFromFile(path);
        finder.findPairsEqualToValue(array, DESIRED_PAIR_SUM);
    }

    private static int[] getIntsArrayFromFile(String path) {
        try {
            var stringFromFile = Files.readString(Paths.get(path));
            var stringArray = stringFromFile.split("\\s");
            return Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException exception) {
            LOGGER.info("Parsing problem occurred: " + exception.getMessage());
        } catch (IOException exception) {
            LOGGER.info("Interrupt with file: " + exception.getMessage());
        }
        return new int[]{};
    }
}
