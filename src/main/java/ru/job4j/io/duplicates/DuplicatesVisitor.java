package ru.job4j.io.duplicates;

import java.util.*;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<Path>> duplicate = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty currentFile = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (duplicate.containsKey(currentFile)) {
            duplicate.get(currentFile).add(file);
        } else {
            duplicate.put(currentFile, new ArrayList<>(Arrays.asList(file)));
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getDuplicate() {
        return duplicate.values().stream()
                .filter(el -> el.size() > 1)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
