package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))
        ) {
            String line = reader.readLine();
            boolean available = true;
            while (line != null) {
                String[] array = line.split("\\s");
                boolean currentAvailable = available;
                if (!line.startsWith("#") && !line.isEmpty() && array.length == 2) {
                    currentAvailable = !"400".equals(array[0]) && !"500".equals(array[0]);
                }
                if (available != currentAvailable) {
                    out.print(array[1] + ";" + (currentAvailable ? System.lineSeparator() : ""));
                    available = currentAvailable;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Analizy().unavailable("./data/source_file.log", "./data/target_file.txt");
    }
}

