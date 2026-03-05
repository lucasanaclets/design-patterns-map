package tests;

import org.junit.Before;
import org.junit.Test;

import adapters.ListToMapAdapter;

import static org.junit.Assert.*;

public class ListToMapAdapterTest {

    private ListToMapAdapter<Integer> map;

    @Before
    public void setUp() {
        map = new ListToMapAdapter<>();
        map.put(0, 1);
        map.put(1, 2);
    }

    @Test
    public void testContainsValue() {
        assertTrue(map.containsValue(1));
        assertFalse(map.containsValue(3));
    }

    @Test
    public void testEquals() {
        ListToMapAdapter<Integer> map2 = new ListToMapAdapter<>();
        map2.put(0, 1);
        map2.put(1, 2);

        assertTrue(map.equals(map2));
    }

    @Test
    public void testGet() {
        assertEquals(Integer.valueOf(1), map.get(0));
        assertEquals(Integer.valueOf(2), map.get(1));
    }

    @Test
    public void testIsEmpty() {
        assertFalse(map.isEmpty());

        map.clear();

        assertTrue(map.isEmpty());
    }

    @Test
    public void testPut() {
        map.put(2, 3);

        assertEquals(3, map.size());
        assertEquals(Integer.valueOf(3), map.get(2));
    }

    @Test
    public void testRemove() {
        assertEquals(Integer.valueOf(2), map.remove(1));
        assertEquals(1, map.size());
    }

    @Test
    public void testSize() {
        assertEquals(2, map.size());
    }

    @Test
    public void testValues() {
        Object[] expectedValues = {1, 2};
        assertArrayEquals(expectedValues, map.values().toArray());
    }
}