package dsaa.datastructures;

/**
 * A generically-typed dynamic array that allows the user to add and remove
 * objects, automatically resizing the underlying array as needed.
 *
 * @param <T> the type of elements in this DynamicArray.
 */
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
     * @param index the index provided.
     * @return the element in the DynamicArray at index i.
     * @throws IndexOutOfBoundsException if the index is out of bounds
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
     * @param index   the index at which to set the element.
     * @param element the new element.
     * @throws IndexOutOfBoundsException if the index is out of bounds
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
     * @param element the element to be added.
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
     * @param index the index at which to remove element.
     * @return the element removed.
     * @throws IndexOutOfBoundsException if the index is out of bounds
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
     * @param element check if this element is in DynamicArray.
     * @return true if element is found, else false.
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
     * @return the size of DynamicArray.
     */
    public int size() {
        return length;
    }

    /**
     * Checks if the DynamicArray is empty.
     * 
     * @return true if empty, otherwise false.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Give a string representation of the DynamicArray.
     * E.g. [1, 2, 3]
     * 
     * @return string of numbers of the array, separated by commas within square
     *         brackets.
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        String arrayStr = "[";
        for (int i = 0; i < length - 1; i++) {
            arrayStr += array[i] + ", ";
        }
        arrayStr += array[length - 1] + "]";
        return arrayStr;
    }
}
