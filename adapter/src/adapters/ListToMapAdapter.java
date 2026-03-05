package adapters;

import interfaces.IMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListToMapAdapter<V> implements IMap<Integer, V> {

    private final List<V> list;

    public ListToMapAdapter() {
        this.list = new ArrayList<>();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        if (!(key instanceof Integer)) {
            return false;
        }

        int index = (Integer) key;
        return index >= 0 && index < list.size();
    }

    @Override
    public boolean containsValue(Object value) {
        return list.contains(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ListToMapAdapter<?> other)) return false;

        return list.equals(other.list);
    }

    @Override
    public V get(Object key) {
        if (!(key instanceof Integer)) {
            return null;
        }

        int index = (Integer) key;

        if (index < 0 || index >= list.size()) {
            return null;
        }

        return list.get(index);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public V put(Integer key, V value) {

        if (key < 0) {
            throw new IndexOutOfBoundsException("Chave deve ser >= 0");
        }

        while (list.size() <= key) {
            list.add(null);
        }

        return list.set(key, value);
    }

    @Override
    public V remove(Object key) {

        if (!(key instanceof Integer)) {
            return null;
        }

        int index = (Integer) key;

        if (index < 0 || index >= list.size()) {
            return null;
        }

        return list.remove(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Collection<V> values() {
        return new ArrayList<>(list);
    }
}