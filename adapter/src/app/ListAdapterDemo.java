package app;

import adapters.MapToListAdapter;
import java.util.Iterator;

public class ListAdapterDemo {

    public static void main(String[] args) {

        MapToListAdapter<Integer> mapToList = new MapToListAdapter<>();

        mapToList.add(1);
        mapToList.add(2);
        mapToList.add(3);

        System.out.println("Tamanho: " + mapToList.size());

        System.out.println("Está vazio? " + mapToList.isEmpty());

        System.out.println("Elemento recuperado: " + mapToList.get(1));

        System.out.println("Tamanho antes de remover: " + mapToList.size());
        mapToList.remove(0);
        System.out.println("Tamanho após remover: " + mapToList.size());

        System.out.println("Contém o elemento 3? " + mapToList.contains(3));

        mapToList.clear();
        System.out.println("Tamanho após limpar: " + mapToList.size());

        System.out.println("É igual: " + mapToList.equals(new MapToListAdapter<>()));

        mapToList.add(5);
        mapToList.add(6);
        mapToList.add(7);

        System.out.println("Iterando:");

        Iterator<Integer> iterator = mapToList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Object[] array = mapToList.toArray();

        System.out.println("Array:");

        for (Object element : array) {
            System.out.println(element);
        }
    }
}