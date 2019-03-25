import java.util.EmptyStackException;

public class DynamicStack {
	protected Node topo; // node topo da pilha
	protected int size; // número de nodes da pilha
	// Construtor default que cria uma pilha vazia

	public DynamicStack() {
		topo = null;
		size = 0;
	}

	/*
	 * Retorna: - true se a pilha está vazia - false caso contrário
	 */
	public boolean isEmpty() {
		return topo == null;
	}

	/* Retorna o número de elementos na pilha */
	public int getSize() {
		return size;
	}

	/* Retorna o elemento no topo da pilha */
	public char showTop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return topo.getElement();
	}

	public void push(char element) {
		Node novo = new Node(element, topo);
		topo = novo;
		size++;
	}

	public char pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		char temp = topo.getElement();
		topo = topo.getNext(); // desencadeira o node topo
		size--;
		return temp;
	}
}
