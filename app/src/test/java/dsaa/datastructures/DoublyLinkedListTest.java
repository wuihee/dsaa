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
}
