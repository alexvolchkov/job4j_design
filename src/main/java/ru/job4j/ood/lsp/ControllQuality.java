package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {

    public void distribution(List<Food> foods, List<Storeable> storages) {
        for (Food food : foods) {
            for (Storeable storage : storages) {
                if (storage.accept(food)) {
                    storage.add(food);
                    break;
                }
            }
        }
    }

    public void resort(List<Storeable> storages) {
        List<Food> foods = new ArrayList<>();
        for (Storeable storage : storages) {
            foods.addAll(storage.findAll());
            storage.clear();
        }
        distribution(foods, storages);
    }
}
