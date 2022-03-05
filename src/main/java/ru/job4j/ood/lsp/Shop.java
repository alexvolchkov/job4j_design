package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Shop implements Storeable {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        foods.add(food);
        double percentToExpiryDay = percentToExpiryDay(food, LocalDate.now());
        if (100 - percentToExpiryDay > 75) {
            food.setPrice(food.getPrice() - food.getPrice() * food.getDiscount());
        }
    }

    @Override
    public List<Food> find(Predicate<Food> filter) {
        return foods.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        double percentToExpiryDay = percentToExpiryDay(food, LocalDate.now());
        if (100 - percentToExpiryDay >= 25 && 100 - percentToExpiryDay < 100) {
            rsl = true;
        }
        return rsl;
    }
}
