package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        String rsl = values.get(key);
        if (rsl == null) {
            throw new IllegalArgumentException(String.format(
                    "Введен не верный ключ %s. Список ключей %s", key, values.keySet()));
        }
        return rsl;
    }

    private void parse(String[] args) {
        for (String arg : args) {
            int index = arg.indexOf("=");
            validation(arg, index);
            String key = arg.substring(1, index);
            String value = arg.substring(index + 1);
            values.put(key, value);
        }
    }

    private void validation(String arg, int index) {
        if (!arg.startsWith("-") || index <= 1 || index == arg.length() - 1) {
            throw new IllegalArgumentException(
                    "Не верно указан параметр. Формат параметра  -key=value");
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void validationArgument(String[] args, int amount) {
        if (args.length != amount) {
            throw new IllegalArgumentException(String.format(
                    "Неверное количество параметров. Должно быть %s. Передано %s", amount, args.length));
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
