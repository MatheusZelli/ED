package util;

public class Main {

	public static void main(String[] args) {
		JDLinkedList lista = new JDLinkedList();
		try {
			lista.insertFirst(new DNode("I"));
			lista.insertFirst(new DNode("L"));
			lista.insertFirst(new DNode("L"));
			lista.insertFirst(new DNode("E"));
			lista.insertFirst(new DNode("Z"));
			lista.removeAfter(2);
//			lista.removeFirst(); // pode lan�ar UnderflowException
//			lista.removeLast(); // pode lan�ar UnderflowException
		} catch (Exception e) {
			System.out.println("ERRO: Imposs�vel remover!");
			e.printStackTrace();
		}
		lista.show();
	}

}
