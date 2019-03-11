package util;

public class JDLinkedList {
	protected DNode head; // node cabeça da lista
	protected DNode tail; // node cauda da lista
	protected long size; // número de nodes da lista
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
			throw new IllegalArgumentException("Está vazio");
		}
		return head;
	}

	public DNode getLast() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Está no último");
		}
		return tail;
	}

	//Inserção no início da lista
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

	//Inserção no final da lista
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

	//Remoção no início da lista
	public DNode removeFirst() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Está vazio");
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

	//Remoção no final da lista
	public DNode removeLast() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Está vazio");
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
			System.out.print("A lista é: ");
			DNode current = head;
			while (current != null) {
				System.out.print(current.getElement().toString() + " ");
				current = current.getNext();
			}
			System.out.println("\n");
		}
	}

	
	//Inserção depois de uma posição qualquer da lista
	public void insertAfter(DNode n, int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= size) { // A lista inicia na posição 0
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
	
	//Remoção depois de uma posição qualquer da lista
	public DNode removeAfter(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= size) { // A lista inicia na posição 0
			throw new IndexOutOfBoundsException();
		}
		if (pos == size - 2) {
			removeLast();
		}
		return null;
	}

}
