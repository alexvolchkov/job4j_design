package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Predicate;

public interface Storeable {

    void add(Food food);

    List<Food> find(Predicate<Food> filter);

    boolean accept(Food food);

    default double percentToExpiryDay(Food food, LocalDate pointDay) {
        return 100.0 * Period.between(pointDay, food.getExpiryDate()).getDays()
                / Period.between(food.getCreateDate(), food.getExpiryDate()).getDays();
    }
}
