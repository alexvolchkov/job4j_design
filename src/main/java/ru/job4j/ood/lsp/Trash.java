package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Trash implements Storeable {
    private List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        double percentToExpiryDay = Utilities.percentToExpiryDay(food, LocalDate.now());
        if (percentToExpiryDay <= 0) {
            foods.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> find(Predicate<Food> filter) {
        return foods.stream().filter(filter).collect(Collectors.toList());
    }
}
