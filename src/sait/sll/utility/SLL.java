package sait.sll.utility;



public class SLL implements LinkedListADT{

	/**
	 * 
	 */

	
	private Node head;
	
	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public void clear() {
		head = null;
	}
	@Override
	public void prepend(Object data) {
	}
	@Override
	public void append(Object data) {
		Node newNode = new Node(data, null);
		if(head == null) {
			head = newNode;
		}else {
			Node current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
	}
	
	
	@Override
	public int size() {
		Node current = head;
		int size = 0;
		while (current != null) {
			size++;
			current = current.getNext();
		}
		return size;
	}
	@Override
	public void delete(int index) throws IndexOutOfBoundsException{
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Invalid Index while replacing");
		}else {
			Node current = head;
			if(index == 0) {
				head = current.getNext();
				
			}else {
				for(int i = 0; i < (index-1) ; i++) {
					current= current.getNext();
				}
				current.setNext(current.getNext().getNext());
			}
		}
	}
	
	
	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int indexOf(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean contains(Object data) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

}
