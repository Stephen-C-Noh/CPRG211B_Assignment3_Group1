package sait.sll.utility;

import java.io.Serializable;

/**
 * Node class used by the singly linked list (SLL).
 * Stores a piece of data and a reference to the next node.
 */
public class Node implements Serializable {

    private static final long serialVersionUID = 1L;

    private Object data;
    private Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
