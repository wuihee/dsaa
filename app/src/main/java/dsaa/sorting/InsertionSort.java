package dsaa.sorting;

public class InsertionSort implements Sort {

    /**
     * Sorts an integer array in-place using insertion sort.
     * 
     * @param A - The array to be sorted.
     */
    public void sort(int[] A) {

        // Check each element and 'insert' it into its correct position.
        // We start at i = 1 because at i = 0 we already have 1 element, which by itself
        // is already in its correct place.
        for (int i = 1; i < A.length; i++) {

            int key = A[i];
            int j = i - 1;

            // Move the current elemet back along the array until it is in its correct
            // place, i.e. the element behind it is less than or equal.
            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j--;
            }

            A[j + 1] = key;
        }
    }
}
