package app;

import adapters.ListToMapAdapter;

public class MapAdapterDemo {

    public static void main(String[] args) {

        ListToMapAdapter<Integer> map1 = new ListToMapAdapter<>();
        ListToMapAdapter<Integer> map2 = new ListToMapAdapter<>();

        System.out.println("É igual: " + map1.equals(map2));

        map1.put(0, 25);
        map1.put(1, 100);
        map1.put(2, 80);
        map1.put(3, 44);
        map1.put(4, 39);

        System.out.println("É igual: " + map1.equals(map2));

        System.out.println("Tamanho do mapa: " + map1.size());

        System.out.println("Primeiro elemento: " + map1.get(0));

        int item = 25;

        boolean contem = map1.containsValue(item);

        System.out.println("Contém " + item + ": " + contem);

        System.out.println("Mapa está vazio: " + map1.isEmpty());

        System.out.println("Values:");

        for (Integer i : map1.values()) {
            System.out.println("- " + i);
        }

        System.out.println("Tamanho antes da remoção: " + map1.size());

        map1.remove(0);

        System.out.println("Tamanho depois da remoção: " + map1.size());

        map1.clear();

        System.out.println("Tamanho após limpeza: " + map1.size());
    }
}