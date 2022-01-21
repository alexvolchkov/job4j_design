package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validation(args);
        Path start = Paths.get(args[0]);
        validation(start);
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void validation(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder and filter are null. "
                    + "Usage java -jar dir.jar ROOT_FOLDER FILTER.");
        } else if (args.length == 1) {
            throw new IllegalArgumentException("Filter is null. "
                    + "Usage java -jar dir.jar ROOT_FOLDER FILTER.");
        }
    }

    public static void validation(Path folder) {
        if (!Files.exists(folder)) {
            throw new IllegalArgumentException(String.format("Not exist %s", folder.toAbsolutePath()));
        } else if (!Files.isDirectory(folder)) {
            throw new IllegalArgumentException(String.format("Not directory %s", folder.toAbsolutePath()));
        }
    }
}
