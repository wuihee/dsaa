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
    public void testAdd() {
        for (int i = 0; i < 100; i++) {
            dynamicArray.add(i);
        }
        assertEquals(100, dynamicArray.size());
    }
}
