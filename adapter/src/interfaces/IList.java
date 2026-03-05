package interfaces;

import java.util.Iterator;

public interface IList<E> {

    void add(E element);

    void clear();

    boolean contains(Object obj);

    boolean equals(Object obj);

    E get(int index);

    boolean isEmpty();

    Iterator<E> iterator();

    E remove(int index);

    int size();

    Object[] toArray();
}