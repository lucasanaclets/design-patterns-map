package adapters;

import interfaces.IList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapToListAdapter<E> implements IList<E> {

    private final Map<Integer, E> map;

    public MapToListAdapter() {
        this.map = new HashMap<>();
    }

    @Override
    public void add(E element) {
        int index = map.size();
        map.put(index, element);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(Object obj) {
        return map.containsValue(obj);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MapToListAdapter<?> other)) return false;

        return map.equals(other.map);
    }

    @Override
    public E get(int index) {
        return map.get(index);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return map.values().iterator();
    }

    @Override
    public E remove(int index) {
        return map.remove(index);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object[] toArray() {
        return map.values().toArray();
    }
}