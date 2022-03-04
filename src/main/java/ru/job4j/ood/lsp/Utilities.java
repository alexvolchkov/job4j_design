package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.Period;

public class Utilities {

    public static double percentToExpiryDay(Food food, LocalDate pointDay) {
        return 100.0 * Period.between(pointDay, food.getExpiryDate()).getDays()
                / Period.between(food.getCreateDate(), food.getExpiryDate()).getDays();
    }
}
