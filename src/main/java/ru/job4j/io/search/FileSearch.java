package ru.job4j.io.search;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FileSearch {

    public static void search(ArgsName argsName) throws IOException {
        Path folder = Paths.get(argsName.get("d"));
        Search.validation(folder);
        String typeSearch = argsName.get("t");
        List<Path> rsl = new ArrayList<>();
        if ("name".equals(typeSearch)) {
          rsl =  Search.search(folder, el -> el.getFileName().toString().equals(argsName.get("n")));
        } else if ("mask".equals(typeSearch)) {
            String regex = argsName.get("n").replace(".", "\\.")
                                            .replace("?", ".?")
                                            .replace("*", ".*?");
            Pattern pattern = createPattern(regex, argsName.get("n"), "*.txt");
            rsl =  Search.search(folder, el -> pattern.matcher(el.getFileName().toString()).find());
        } else if ("regex".equals(typeSearch)) {
            Pattern pattern = createPattern(argsName.get("n"), argsName.get("n"), ".*?\\.txt");
            rsl =  Search.search(folder, el -> pattern.matcher(el.getFileName().toString()).find());
        }
        try (PrintWriter pw = new PrintWriter(argsName.get("o"))) {
            rsl.forEach(pw::println);
        }
    }

    private static Pattern createPattern(String regex, String originalRegex, String pattern) {
        try {
            return Pattern.compile(regex);
        } catch (PatternSyntaxException e) {
            throw new PatternSyntaxException(String.format("Не верно задано выражение регулярного выражения. "
                    + "Пример -n={}", pattern),
                    originalRegex, -1);
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName.validationArgument(args, 4);
        search(ArgsName.of(args));
    }
}
