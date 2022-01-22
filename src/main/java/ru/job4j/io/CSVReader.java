package ru.job4j.io;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReader {

    public static void handle(ArgsName argsName) throws Exception {
        Path file = Paths.get(argsName.get("path"));
        validation(file);
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        List<String> filter = parseString(argsName.get("filter"), ",");
        List<String> rsl = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            boolean firstStep = true;
            Set<Integer> indexFilter = new TreeSet<>();
            while (scanner.hasNextLine()) {
                List<String> listString = parseString(scanner.nextLine(), delimiter);
                if (firstStep) {
                    indexFilter = parseIndex(filter, listString);
                    firstStep = false;
                }
                rsl.add(parseString(listString, indexFilter, delimiter));
            }
        }
        if ("stdout".equals(out)) {
            rsl.forEach(System.out::println);
        } else {
            try (PrintWriter pw = new PrintWriter(out)) {
                rsl.forEach(pw::println);
            }
        }
    }

    private static Set<Integer> parseIndex(List<String> filter, List<String> listString) {
        Set<Integer> rsl = new TreeSet<>();
        for (String s : filter) {
            int index = listString.indexOf(s);
            if (index != -1) {
                rsl.add(index);
            }
        }
        return rsl;
    }

    private static String parseString(List<String> listString, Set<Integer> indexFilter, String delimiter) {
       return indexFilter.stream()
               .map(listString::get)
                .collect(Collectors.joining(delimiter));
    }

    private static List<String> parseString(String string, String delimiter) {
        Scanner scanner = new Scanner(string).useDelimiter(delimiter);
        List<String> rsl = new ArrayList<>();
        while (scanner.hasNext()) {
            rsl.add(scanner.next());
        }
        return rsl;
    }

    private static void validation(Path file) {
        if (!Files.exists(file)) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.toAbsolutePath()));
        } else if (Files.isDirectory(file)) {
            throw new IllegalArgumentException(String.format("It is directory %s", file.toAbsolutePath()));
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName.validationArgument(args, 4);
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
