package util;

public class JDLinkedList {
	protected DNode head; // node cabe�a da lista
	protected DNode tail; // node cauda da lista
	protected long size; // n�mero de nodes da lista
	// Construtor default que cria uma lista vazia

	public JDLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public DNode getFirst() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Est� vazio");
		}
		return head;
	}

	public DNode getLast() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Est� no �ltimo");
		}
		return tail;
	}

	//Inser��o no in�cio da lista
	public void insertFirst(DNode novoNode) {
		if (isEmpty()) {
			head = novoNode;
			tail = novoNode;
			size++;
		} else {
			novoNode.setNext(head);
			head.setPrevious(novoNode);
			head = novoNode;
			size++;
		}
	}

	//Inser��o no final da lista
	public void insertLast(DNode novoNode) {
		if (isEmpty()) {
			insertFirst(novoNode);
		} else {
			tail.setNext(novoNode);
			novoNode.setPrevious(tail);
			tail = novoNode;
			size++;
		}
	}

	//Remo��o no in�cio da lista
	public DNode removeFirst() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Est� vazio");
		}
		DNode removedItem = head;
		if (head == tail) {
			head = tail = null;
		} else {
			head.getNext().setPrevious(null);
			head = head.getNext();
		}
		size--;
		return removedItem;
	}

	//Remo��o no final da lista
	public DNode removeLast() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Est� vazio");
		}
		DNode removedItem = tail;
		if (head == tail) {
			head = tail = null;
		} else {
			tail.getPrevious().setNext(null);
			tail = tail.getPrevious();
		}
		size--;
		return removedItem;
	}
	
	//Mostrar/exibir elementos da lista
	public void show() {
		if (isEmpty()) {
			System.out.println("Lista vazia!");
		} else {
			System.out.print("A lista �: ");
			DNode current = head;
			while (current != null) {
				System.out.print(current.getElement().toString() + " ");
				current = current.getNext();
			}
			System.out.println("\n");
		}
	}

	
	//Inser��o depois de uma posi��o qualquer da lista
	public void insertAfter(DNode n, int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= size) { // A lista inicia na posi��o 0
			throw new IndexOutOfBoundsException();
		}
		if (pos == size - 1) {
			insertLast(n);
		} else {
			long posAtual;
			DNode current;
			if (pos < (size / 2)) {
				posAtual = 0;
				current = head;
			} else {
				posAtual = size - 1;
				current = tail;
			}
			if (current == head) {
				while (posAtual < pos) {
					current = current.getNext();
					posAtual++;
				}
			} else {
				while (posAtual > pos) {
					current = current.getPrevious();
					posAtual--;
				}
			}
			n.setNext(current.getNext());
			n.setPrevious(current);
			current.getNext().setPrevious(n);
			current.setNext(n);
			size++;
		}
	}
	
	//Remo��o depois de uma posi��o qualquer da lista
	public DNode removeAfter(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= size) { // A lista inicia na posi��o 0
			throw new IndexOutOfBoundsException();
		}
		if (pos == size - 2) {
			removeLast();
		}
		return null;
	}

}
