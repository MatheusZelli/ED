
public class Main {
	public static void main(String args[]) {
		DynamicStack pilha = new DynamicStack();
		try {
			pilha.push('A');
			pilha.push('V');
			pilha.push('A');
			pilha.push('J');
			pilha.push('J');
			pilha.pop(); // pode lan�ar EmptyStackException
			while (!pilha.isEmpty()) {
				System.out.print(pilha.pop() + " ");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("ERRO: Imposs�vel remover!");
			e.printStackTrace();
		}
	}
}
