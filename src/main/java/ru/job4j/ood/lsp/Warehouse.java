package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Warehouse implements Storeable {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (accept(food)) {
            foods.add(food);
        }
    }

    @Override
    public List<Food> find(Predicate<Food> filter) {
        return foods.stream().filter(filter).collect(Collectors.toList());
    }

    @Override
    public List<Food> findAll() {
        return new ArrayList<>(foods);
    }

    @Override
    public void clear() {
        foods.clear();
    }

    @Override
    public boolean accept(Food food) {
        return percentToExpiryDay(food, LocalDate.now()) > 75;
    }
}
