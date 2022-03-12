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
        boolean accept = accept(food);
        if (accept && percentToExpiryDay(food, LocalDate.now()) < 25) {
            foods.add(food);
            food.setPrice(food.getPrice() - food.getPrice() * food.getDiscount());
        } else if (accept) {
            foods.add(food);
        }
    }

    @Override
    public List<Food> find(Predicate<Food> filter) {
        return foods.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public List<Food> findAll() {
        return foods;
    }

    @Override
    public void clear() {
        foods.clear();
    }

    @Override
    public boolean accept(Food food) {
        double percentToExpiryDay = percentToExpiryDay(food, LocalDate.now());
        return percentToExpiryDay <= 75 && percentToExpiryDay > 0;
    }
}
