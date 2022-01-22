package ru.job4j.io;

import java.util.List;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target.toFile())))
        ) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(source.toFile()))
                ) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target)))
        ) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(
                    new FileInputStream(source))
            ) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void packing(String[] args) throws IOException {
        ArgsName.validationArgument(args, 3);
        ArgsName values =  ArgsName.of(args);
        Path directory = Paths.get(values.get("d"));
        Search.validation(directory);
        StringBuilder tempExclude = new StringBuilder(values.get("e"));
        String exclude = tempExclude.toString().startsWith(".")
                ? tempExclude.toString()
                : tempExclude.insert(0, ".").toString();
        Path output = Paths.get(values.get("o"));
        List<Path> sources = Search.search(
                directory,
                p -> !p.toFile().getName().endsWith(exclude)
        );
        packFiles(sources, output);
    }

    public static void main(String[] args) throws IOException {
        packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        packing(args);
    }
}
