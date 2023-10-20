package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Aleksandr Volchkov
 */
public class Balancer {

    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        if (nodes == null || nodes.isEmpty()) {
            throw new IllegalArgumentException("Nodes %s should not be empty".formatted(nodes));
        }
        for (int i = 0; i < nodes.size();) {
            if (source.hasNext()) {
                nodes.get(i).add(source.next());
                i = i == nodes.size() - 1 ? 0 : i + 1;
            } else {
                i = nodes.size();
            }
        }
    }
}
