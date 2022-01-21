package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        boolean run = true;
        boolean readPhrases = true;
        List<String> chat = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Начало чата");
        while (run) {
            String ask = input.nextLine();
            if (OUT.equalsIgnoreCase(ask)) {
                run = false;
                break;
            } else if (STOP.equalsIgnoreCase(ask)) {
                readPhrases = false;
            } else if (CONTINUE.equalsIgnoreCase(ask)) {
                readPhrases = true;
            }
            chat.add("User: " + ask);
            if (readPhrases) {
                String botPhrases = readPhrases().stream().collect(Collectors.joining(" "));
                System.out.println(botPhrases);
                chat.add("Bot: " + botPhrases);
            }
        }
        System.out.println("Разговор завершился");
        saveLog(chat);
    }

    private List<String> readPhrases() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, Charset.forName("UTF-8")))) {
            List<String> listWords = br.lines()
                    .map(s -> s.split("\\s"))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
            int countWords = (int) (Math.random() * 5) + 1;
            for (int i = 0; i < countWords; i++) {
                rsl.add(
                        listWords.get(
                                (int) (Math.random() * listWords.size() - 1)
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("UTF-8")))) {
            log.forEach(pw::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/chat.log", "./data/source_bot_answers.txt");
        cc.run();
    }
}
