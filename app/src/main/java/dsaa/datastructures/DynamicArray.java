package dsaa.datastructures;

public class DynamicArray<T> {
    private final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int capacity;

    @SuppressWarnings("unchecked")
    public DynamicArray() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public DynamicArray(T[] array) {
        this.array = array;
        capacity = array.length;
    }
}
