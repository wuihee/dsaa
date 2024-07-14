package dsaa.datastructures;

public class DynamicArray<T> {
    private final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int capacity;
    private int length;

    /**
     * Initializes a DynamicArray with a default capacity.
     */
    @SuppressWarnings("unchecked")
    public DynamicArray() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        length = 0;
    }

    /**
     * Retrieves element in the array at position i.
     * 
     * @param index - The index provided.
     * @return - Element in the DynamicArray at index i.
     */
    public T get(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("Index provided is out of bounds.");
        }
        return array[index];
    }

    /**
     * Sets element at index i to be a new element.
     * 
     * @param index   - The index at which to set the element.
     * @param element - The new element.
     */
    public void set(int index, T element) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("Index provided is out of bounds.");
        }
        array[index] = element;
    }

    /**
     * Add a new element to the end of the DynamicArray.
     * 
     * @param element - Element to be added.
     */
    @SuppressWarnings("unchecked")
    public void add(T element) {
        if (length + 1 >= capacity) {
            capacity *= 2;
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[length] = element;
        length++;
    }

    /**
     * Remove the element at the specified index.
     * 
     * @param index - Index at which to remove element.
     * @return - The element removed.
     */
    public T removeAt(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("Index provided is out of bounds.");
        }
        T element = get(index);
        for (int i = index; i < length - 1; i++) {
            array[index] = array[index + 1];
        }
        length--;
        return element;
    }

    /**
     * Checks if the DynamicArray contains a given element.
     * 
     * @param element - Check if this element is in DynamicArray.
     * @return - True if element is found, else false.
     */
    public boolean contains(T element) {
        for (int i = 0; i < length; i++) {
            if (array[i].equals(element)) {
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
        return length;
    }
}
