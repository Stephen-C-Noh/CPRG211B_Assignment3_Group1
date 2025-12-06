package sait.sll.utility;

import java.io.Serializable;

public class SLL implements LinkedListADT, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	// Attributes
	private Node head;
	private int size;

	// Constructor
	public SLL() {
		head = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public void append(Object data) {
		// new node
		Node newNode = new Node(data, null);
		if (isEmpty()) {
			// if the list is empty, newNode is now head.
			head = newNode;
		} else {
			// if the list is NOT empty, go through the list
			// until current gets to the last node
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			// Then set the newNode as next node.
			current.setNext(newNode);
		}
		size++;
	}

	@Override
	public void prepend(Object data) {
		// adding a node at the beginning of the singly linked list.

		// set the next node of newNode as head(first node).
		Node newNode = new Node(data, head);
		// then make newNode a head(first node)
		// the previous first node is now the second.
		head = newNode;
		size++;
	}

	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index is Out of Bound while inserting.");
		}

		if (index == 0) {
			// if inserting at the beginning of SLL, just prepend!
			prepend(data);
		} else {
			Node newNode = new Node(data, null);
			Node current = head;
			// insert(data, 3)
			// index = 3
			
			for (int i = 0; i < index - 1; i++) {
				// Move the current node to desired index.
				current = current.getNext();
			}

			// then set next node for newNode one after current.
			// then overwrite current node with newNode.
			// Example: SLL[A, B, C, D] index: 2
			// SLL[A, B, * C, D] * is the current node
			
			newNode.setNext(current.getNext());
			// Now newNode has C as the next node
			
			current.setNext(newNode);
			// Now *(current) has next node of newNode
			// Result SLL [A,B,N,C,D]
			size++;
		}
	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid Index while replacing");
		}
		Node current = head;
		for (int i = 0; i < index; i++) {			
			current = current.getNext();
		}
		current.setData(data);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid Index while deleting.");
		}

		if (index == 0) {
			head = head.getNext();
		} else {
			Node current = head;
			for (int i = 0; i < index-1; i++) {
				current = current.getNext();
			}
			current.setNext(current.getNext().getNext());
		}
		size--;
	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid Index while retrieving");
		}

		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getData();
	}

	@Override
	public int indexOf(Object data) {
		Node current = head;
		int index = 0;
		while (current != null) {
			if (current.getData().equals(data)) {
				return index;
			}
			current = current.getNext();
			index++;
		}
		return -1;
		// returning -1 instead of 0(false) because 0 can be index.
	}

	@Override
	public boolean contains(Object data) {
		return (indexOf(data) != -1);
	}

	/* There is ONE error in test casing.
	 * For easier tracking, implementing printList method temporarily.
	 * */
	public void printList() {
		Node current = head;
		while(current != null) {
			System.out.print(current.getData() + " -> ");
			current = current.getNext();
		}
		System.out.println("null // end of list");
	}
}
