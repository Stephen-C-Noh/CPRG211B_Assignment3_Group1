package sait.sll.utility;

import java.io.Serializable;

/**
 * Singly linked list implementation of LinkedListADT.
 * Stores values in Node objects linked together.
 * 
 * @version 2025
 */
public class SLL implements LinkedListADT, Serializable {
    
    // Required for Serializable classes.
    private static final long serialVersionUID = 1L;

    /**
     * Reference to the first node in the list.
     * If head is null, the list is empty.
     */
    private Node head;

    /**
     * Returns true if the list has no nodes.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Removes all nodes from the list.
     */
    @Override
    public void clear() {
        head = null;
    }

    /**
     * Adds a new node to the beginning of the list.
     * Example: list = [b, c], prepend(a) => [a, b, c]
     */
    @Override
    public void prepend(Object data) {
        head = new Node(data, head);
    }

    /**
     * Adds a new node to the end of the list.
     * Example: list = [a, b], append(c) => [a, b, c]
     */
    @Override
    public void append(Object data) {
        Node newNode = new Node(data, null);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    /**
     * Counts how many nodes are in the list.
     */
    @Override
    public int size() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.getNext();
        }

        return count;
    }

    /**
     * Helper method to check if an index is valid.
     * 
     * @param index          index to check
     * @param allowEqualSize if true, index == size() is allowed (for insert)
     */
    private void checkIndex(int index, boolean allowEqualSize) {
        int sz = size();

        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative: " + index);
        }

        if (!allowEqualSize && index >= sz) {
            // For methods that require 0 .. size()-1
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        if (allowEqualSize && index > sz) {
            // For insert where 0 .. size() is allowed
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }

    /**
     * Deletes the node at the given index.
     * Valid indexes: 0 .. size()-1
     */
    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        checkIndex(index, false);

        // Remove first node
        if (index == 0) {
            head = head.getNext();
            return;
        }

        // Find node just before the one we want to remove
        Node previous = head;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.getNext();
        }

        Node toRemove = previous.getNext();
        previous.setNext(toRemove.getNext());
    }

    /**
     * Inserts a node at the given index.
     * Valid indexes: 0 .. size()
     *  - 0 means insert at beginning
     *  - size() means insert at end
     */
    @Override
    public void insert(Object data, int index) throws IndexOutOfBoundsException {
        checkIndex(index, true);

        // Insert at front
        if (index == 0) {
            prepend(data);
            return;
        }

        // Find node just before the insert position
        Node previous = head;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.getNext();
        }

        Node newNode = new Node(data, previous.getNext());
        previous.setNext(newNode);
    }

    /**
     * Replaces the data at the given index with a new value.
     * Valid indexes: 0 .. size()-1
     */
    @Override
    public void replace(Object data, int index) throws IndexOutOfBoundsException {
        checkIndex(index, false);

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        current.setData(data);
    }

    /**
     * Returns the index of the first node whose data equals the given value.
     * Returns -1 if the value is not found.
     */
    @Override
    public int indexOf(Object data) {
        int index = 0;
        Node current = head;

        while (current != null) {
            Object value = current.getData();

            if (value == null && data == null) {
                return index;
            }

            if (value != null && value.equals(data)) {
                return index;
            }

            index++;
            current = current.getNext();
        }

        return -1;
    }

    /**
     * Returns true if the list contains the given value.
     */
    @Override
    public boolean contains(Object data) {
        return indexOf(data) != -1;
    }

    /**
     * Returns the data stored at the given index.
     * Valid indexes: 0 .. size()-1
     */
    @Override
    public Object retrieve(int index) throws IndexOutOfBoundsException {
        checkIndex(index, false);

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }
}
