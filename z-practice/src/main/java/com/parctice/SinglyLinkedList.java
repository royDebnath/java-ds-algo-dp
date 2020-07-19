package com.parctice;

 class SinglyLinkedList {
	private static Node head;
	private static int numNodes;

	public SinglyLinkedList(Object data) {
		head = new Node(data);
	}

	public static void main(String[] args) {
		
		SinglyLinkedList ll = new SinglyLinkedList(0);
		ll.addAtTail(1);
		ll.addAtTail(2);
		ll.addAtTail(3);
		ll.addAtTail(4);
		ll.addAtTail(5);
		ll.addAtTail(6);
		ll.addAtTail(7);
		ll.addAtHead(100);
		ll.addAtTail(101);
		ll.printList();

	}

	public void addAtHead(Object data) {
		Node current = head;
		head = new Node(data);
		head.next = current;
		numNodes++;
	}

	public void addAtTail(Object data) {
		Node current = head;

		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
		numNodes++;
	}

	public void addAtIndex(int index, Object data) {
		Node current = head;
		for (int i = 0; i <= index && current.next != null; i++) {
			current = current.next;
		}
		Node temp = current.next;
		current.next = new Node(data);
		current.next.next = temp;
		numNodes++;
	}

	public void deleteAtHead() {
		head = head.next;
		numNodes--;
	}

	/*public void deleteAtTail() {
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		numNodes--;
	}

	public void deleteAtIndex(int index) {
		Node current = head;
		for (int i = 0; i <= index && current.next != null; i++) {
			current = current.next;
		}
		current.next = current.next.next;
		numNodes--;
	}*/
	
	public static void printList(){
		Node current=head;
		System.out.print("HEAD->");
		while(current.next!=null){
			System.out.print(current.data+"->");
			current=current.next;
		}
		if(current.next==null){
			System.out.print("END");
		}
	}
	
	class Node {
		private Object data;
		Node next;

		public Node(Object data) {
			this.data = data;
		}

		public Object getData() {
			return data;
		}
	}

}


