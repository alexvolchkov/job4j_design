package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            int read;
            StringBuilder text = new StringBuilder();
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            for (String s : text.toString().split(System.lineSeparator())) {
                System.out.println("Число " + s + " четное: " + (Integer.valueOf(s) % 2 == 0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
