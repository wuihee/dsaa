package dsaa.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public abstract class SortTest {
    public abstract Sort getSort();

    @Test
    public void sortTest() {
        int[] A = { 5, 2, 4, 1, 3 };
        Sort sortingAlgorithm = getSort();
        sortingAlgorithm.sort(A);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, A);
    }
}
