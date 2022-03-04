package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Shop implements Storeable {
    List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        double percentToExpiryDay = Utilities.percentToExpiryDay(food, LocalDate.now());
        if (100 - percentToExpiryDay >= 25 && 100 - percentToExpiryDay < 100) {
            foods.add(food);
            rsl = true;
        }
        if (rsl && 100 - percentToExpiryDay > 75) {
            food.setPrice(food.getPrice() - food.getPrice() * food.getDiscount());
        }
        return rsl;
    }

    @Override
    public List<Food> find(Predicate<Food> filter) {
        return foods.stream().filter(filter).collect(Collectors.toList());
    }
}
