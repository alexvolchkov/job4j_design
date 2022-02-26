package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return compare(value, comparator.reversed());
    }

    public <T> T compare(List<T> value, Comparator<T> comparator) {
        T rsl = null;
        if (value.size() > 0) {
            rsl = value.get(0);
        }
        for (int i = 1; i < value.size(); i++) {
            if (comparator.compare(rsl, value.get(i)) < 0) {
                rsl = value.get(i);
            }
        }
        return rsl;
    }
}
