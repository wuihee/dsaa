package dsaa.datastructures;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {
    private DynamicArray<Integer> dynamicArray;

    @BeforeEach
    public void setUp() {
        dynamicArray = new DynamicArray<>();
    }

    @Test
    public void testSize() {
        assertEquals(0, dynamicArray.size());
    }

    @Test
    public void testAdd() {
        for (int i = 0; i < 100; i++) {
            dynamicArray.add(i);
        }
        assertEquals(100, dynamicArray.size());
    }

    @Test
    public void testContains() {
        for (int i = 0; i < 20; i++) {
            dynamicArray.add(i);
        }
        assertTrue(dynamicArray.contains(10));
    }

    @Test
    public void testGet() {
        for (int i = 0; i < 20; i++) {
            dynamicArray.add(i);
        }
        assertEquals(10, dynamicArray.get(10));
    }

    @Test
    public void testSet() {
        dynamicArray.add(10);
        dynamicArray.set(0, 20);
        assertEquals(20, dynamicArray.get(0));
    }

    @Test
    public void testRemove() {
        for (int i = 0; i < 20; i++) {
            dynamicArray.add(i);
        }
        for (int i = 0; i < 20; i++) {
            dynamicArray.removeAt(0);
        }
        assertEquals(0, dynamicArray.size());

        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        int removed = dynamicArray.removeAt(1);
        assertEquals(2, removed);
        assertEquals(2, dynamicArray.size());
        assertEquals(1, dynamicArray.get(0));
        assertEquals(3, dynamicArray.get(1));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(dynamicArray.isEmpty());
        dynamicArray.add(1);
        assertFalse(dynamicArray.isEmpty());
        dynamicArray.removeAt(0);
        assertTrue(dynamicArray.isEmpty());
    }

    @Test
    public void testToString() {
        assertEquals("[]", dynamicArray.toString());
        for (int i = 0; i < 3; i++) {
            dynamicArray.add(i);
        }
        assertEquals("[0, 1, 2]", dynamicArray.toString());
    }

    @Test
    public void testIterator() {
        for (int i = 0; i < 10; i++) {
            dynamicArray.add(i);
        }
        for (int i : dynamicArray) {
            System.out.println(i);
        }
    }
}
