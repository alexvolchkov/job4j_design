package ru.job4j.ood.lsp;

import java.util.List;
import java.util.function.Predicate;

public interface Storeable {

    boolean add(Food food);

    List<Food> find(Predicate<Food> filter);
}
