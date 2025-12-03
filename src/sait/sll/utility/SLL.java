package sait.sll.utility;

import java.io.Serializable;


public class SLL implements LinkedListADT, Serializable {

    
    private Node head;

    
    private int size;

    
    public SLL() {
        this.head = null;
        this.size = 0;
    }

    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    
    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    
    @Override
    public void append(Object data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            // List is empty, new node becomes the head.
            this.head = newNode;
        } else {
            // Walk to the last node.
            Node current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            // Link new node at the end.
            current.setNext(newNode);
        }

        this.size++;
    }

   
    @Override
    public void prepend(Object data) {
        Node newNode = new Node(data);
        newNode.setNext(this.head);
        this.head = newNode;
        this.size++;
    }

    
    @Override
    public void insert(Object data, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        if (index == 0) {
            // Insert at the beginning.
            prepend(data);
        } else if (index == this.size) {
            // Insert at the end.
            append(data);
        } else {
            // Insert in the middle.
            Node newNode = new Node(data);

            // Find node just before the insertion point.
            Node previous = this.head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getNext();
            }

            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
            this.size++;
        }
    }

    
    @Override
    public void replace(Object data, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        current.setData(data);
    }

    
    @Override
    public int size() {
        return this.size;
    }

    
    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        if (index == 0) {
            // Remove first node.
            this.head = this.head.getNext();
        } else {
            // Find node just before the one we want to remove.
            Node previous = this.head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getNext();
            }

            Node toRemove = previous.getNext();
            previous.setNext(toRemove.getNext());
        }

        this.size--;
    }

    
    @Override
    public Object retrieve(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

  
    @Override
    public int indexOf(Object data) {
        Node current = this.head;
        int index = 0;

        while (current != null) {
            Object currentData = current.getData();

            if (data == null) {
                if (currentData == null) {
                    return index;
                }
            } else {
                if (data.equals(currentData)) {
                    return index;
                }
            }

            current = current.getNext();
            index++;
        }

        return -1;
    }

   
    @Override
    public boolean contains(Object data) {
        return indexOf(data) != -1;
    }
}
