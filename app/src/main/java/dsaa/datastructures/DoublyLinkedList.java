package dsaa.datastructures;

import java.util.*;

/**
 * A generic doubly-linked list implementation.
 * 
 * @param <T> the type of element to be held in this list.
 */
public class DoublyLinkedList<T> implements Iterable<T> {
    private int size;
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Remove all elements in the linked list.
     */
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Retrieve the number of elements in the linked list.
     * 
     * @return size of the linked list.
     */
    public int size() {
        return size;
    }

    /**
     * Check if the Linked List is empty.
     * 
     * @return true if the linked list contains no elements, otherwise false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add an element at a given index.
     * 
     * @param index   the index position at which to add the new element.
     * @param element the element which to add to the linked list.
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == size - 1) {
            addLast(element);
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node newNode = new Node(element, current.prev, current);
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    /**
     * Add an element to the start of the linked list.
     * 
     * @param element the element to add.
     */
    public void addFirst(T element) {
        Node newHead = new Node(element, null, head);
        if (head != null) {
            head.prev = newHead;
        } else {
            tail = newHead;
        }
        head = newHead;
        size++;
    }

    /**
     * Add an element to the end of the linked list.
     * 
     * @param element the element to add.
     */
    public void addLast(T element) {
        Node newTail = new Node(element, tail, null);
        if (tail != null) {
            tail.next = newTail;
        } else {
            head = newTail;
        }
        tail = newTail;
        size++;
    }

    /**
     * Remove the first instance of the specified element.
     * 
     * @param element the element to remove.
     */
    public void remove(T element) {
        if (isEmpty()) {
            return;
        }
        if (head.value.equals(element)) {
            size--;
            removeFirst();
        } else {
            Node trav = head;
            while (trav.next != null) {
                if (trav.next.value.equals(element)) {
                    trav.next = trav.next.next;
                    size--;
                    return;
                }
                trav = trav.next;
            }
        }
    }

    /**
     * Remove the first element of the linked list.
     */
    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
        if (head == null) {
            tail = null;
        }
    }

    /**
     * Remove the last element of the linked list.
     */
    public void removeLast() {
        if (isEmpty()) {
            return;
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        size--;
        if (tail == null) {
            head = null;
        }
    }

    /**
     * Retrieve the index of the frst occurence of element.
     * 
     * @param element the element to check.
     * @return the index of the element. If not found, return -1.
     */
    public int indexOf(T element) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.value == element) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    /**
     * Returns a string representation of the DoublyLinkedList.
     * 
     * @return elements of the linked list in brackets. E.g. [1, 2, 3].
     */
    @Override
    public String toString() {
        String linkedList = "[";
        Node trav = head;

        if (trav == null) {
            return "[]";
        }

        while (trav.next != null) {
            linkedList += trav.value + ", ";
            trav = trav.next;
        }
        linkedList += trav.value + "]";
        return linkedList;
    }

    /**
     * Allows the use of an enhanced for-loop to iterate over DoublyLinkedList.
     * 
     * @return an iterator object.
     */
    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator();
    }

    /**
     * Node class representing a single node in this linked list.
     */
    private class Node {
        T value;
        Node prev;
        Node next;

        /**
         * Construct a new node with a value and reference pointers.
         * 
         * @param value the value to be stored in this node.
         * @param prev  reference to the previous node.
         * @param next  reference to the next node.
         */
        public Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    /**
     * Iterator for the DoublyLinkedList that specifies how we want to iterate.
     */
    private class DoublyLinkedListIterator implements Iterator<T> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}
