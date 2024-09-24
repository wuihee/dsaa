package dsaa.datastructures;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {
    private DoublyLinkedList<Integer> linkedList;

    @BeforeEach
    public void setUp() {
        linkedList = new DoublyLinkedList<>();
    }

    @Test
    public void testSize() {
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testAddFirst() {
        for (int i = 0; i < 100; i++) {
            linkedList.addFirst(i);
        }
        assertEquals(100, linkedList.size());
    }

    @Test
    public void testAddLast() {
        for (int i = 0; i < 100; i++) {
            linkedList.addLast(i);
        }
        assertEquals(100, linkedList.size());
    }

    @Test
    public void testAdd() {
        linkedList.add(0, 0);
        assertEquals(1, linkedList.size());
        for (int i = 1; i < 5; i++) {
            linkedList.addLast(i);
        }
        linkedList.add(1, 6);
        assertEquals("[0, 6, 1, 2, 3, 4]", linkedList.toString());
    }

    @Test
    public void testRemoveFirst() {
        for (int i = 0; i < 5; i++) {
            linkedList.addLast(i);
        }
        linkedList.removeFirst();
        assertEquals("[1, 2, 3, 4]", linkedList.toString());

        for (int i = 0; i < 4; i++) {
            linkedList.removeFirst();
        }
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testRemoveLast() {
        for (int i = 0; i < 5; i++) {
            linkedList.addLast(i);
        }
        linkedList.removeLast();
        assertEquals("[0, 1, 2, 3]", linkedList.toString());

        for (int i = 0; i < 4; i++) {
            linkedList.removeFirst();
        }
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testRemove() {
        for (int i = 0; i < 5; i++) {
            linkedList.addLast(i);
        }
        linkedList.remove(3);
        assertEquals("[0, 1, 2, 4]", linkedList.toString());
    }

    @Test
    public void testIndexOf() {
        for (int i = 0; i < 100; i++) {
            linkedList.addLast(i);
        }
        assertEquals(50, linkedList.indexOf(50));
    }

    @Test
    public void testToString() {
        for (int i = 0; i < 3; i++) {
            linkedList.addLast(i);
        }
        assertEquals("[0, 1, 2]", linkedList.toString());
    }

    @Test
    public void testIterator() {
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(i);
        }
        for (int i : linkedList) {
            System.out.println(i);
        }
    }
}
