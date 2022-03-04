package ru.job4j.ood.lsp;

import java.util.List;

public class ControllQuality {

    public void distribution(List<Food> foods, List<Storeable> storages) {
        for (Food food : foods) {
            for (Storeable storage : storages) {
                if (storage.add(food)) {
                    break;
                }
            }
        }
    }
}
