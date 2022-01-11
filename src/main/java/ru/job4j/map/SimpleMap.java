package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (1.0 * count / capacity >= LOAD_FACTOR) {
            expand();
        }
        boolean rsl = false;
        int hashCode = key == null ? 0 : key.hashCode();
        int hash =  hash(hashCode);
        int index = indexFor(hash);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value, hash);
            count++;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        MapEntry<K, V>[] oldTable = table;
        capacity *= 2;
        table = new MapEntry[capacity];
        for (MapEntry<K, V> mapEntry : oldTable) {
            if (mapEntry != null) {
                int index = indexFor(mapEntry.hash);
                table[index] = mapEntry;
            }
        }
    }

    @Override
    public V get(K key) {
        int hashCode = key == null ? 0 : key.hashCode();
        int hash =  hash(hashCode);
        int index = indexFor(hash);
        return table[index] != null && isEqualsKey(index, hash, key) ? table[index].value : null;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int hashCode = key == null ? 0 : key.hashCode();
        int hash =  hash(hashCode);
        int index = indexFor(hash);
        if (table[index] != null && isEqualsKey(index, hash, key)) {
            table[index] = null;
            count--;
            rsl = true;
            modCount++;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int point = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (table[point] == null) {
                    while (point < capacity && table[point] == null) {
                        point++;
                    }
                }
                return point < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[point++].key;
            }
        };
    }

    private boolean isEqualsKey(int index, int hash, K key) {
        return table[index].hash == hash && Objects.equals(table[index].key, key);
    }

    private static class MapEntry<K, V> {

        K key;
        V value;
        final int hash;

        public MapEntry(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }

    }
}
