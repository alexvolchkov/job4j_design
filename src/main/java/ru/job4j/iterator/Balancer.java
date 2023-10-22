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
        int index = 0;
        while (source.hasNext()) {
            index = index == nodes.size() ? 0 : index;
            nodes.get(index++).add(source.next());
        }
    }
}
