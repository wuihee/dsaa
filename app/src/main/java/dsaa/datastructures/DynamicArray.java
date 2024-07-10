package dsaa.datastructures;

public class DynamicArray<T> {
    private final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int capacity;

    /**
     * Initializes a DynamicArray with a default capacity.
     */
    @SuppressWarnings("unchecked")
    public DynamicArray() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    /**
     * Retrieves element in the array at position i.
     * 
     * @param i - The index provided.
     * @return - Element in the DynamicArray at index i.
     */
    public T get(int i) {
        if (i >= capacity) {
            throw new IndexOutOfBoundsException("Index provided is out of bounds.");
        }
        return array[i];
    }

    /**
     * Checks if the DynamicArray contains a given element.
     * 
     * @param element - Check if this element is in DynamicArray.
     * @return - True if element is found, else false.
     */
    public boolean contains(T element) {
        for (T item : array) {
            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves the number of elements in the DynamicArray.
     * 
     * @return - Size of DynamicArray.
     */
    public int size() {
        return capacity;
    }
}
